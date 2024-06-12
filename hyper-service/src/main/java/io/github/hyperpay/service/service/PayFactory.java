package io.github.hyperpay.service.service;

import io.github.hyperpay.common.enums.PayTerminalEnum;
import io.github.hyperpay.common.enums.PaywayEnum;
import io.github.hyperpay.common.enums.ResponseErrorCodeEnum;
import io.github.hyperpay.common.enums.config.WXPayConfigCheckResponseEnum;
import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;
import io.github.hyperpay.service.core.LettuceRedisClient;
import io.github.hyperpay.service.core.pay.config.BasePayConfigObj;
import io.github.hyperpay.service.core.pay.config.wx.WXPayConfigObj;
import io.github.hyperpay.service.enums.PayServiceEnum;
import io.github.hyperpay.service.utils.PayNumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;


/**
 * 功能描述: 支付工厂-类
 *
 * @author hubao
 * @since 2024/4/1$ 14:46$
 */
@Slf4j
@Component
public class PayFactory {


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private LettuceRedisClient lettuceRedisClient;

    @Autowired
    private PayConfigService payConfigService;

    @Autowired
    private PayNumberUtil payNumberUtil;


    public ResponseVO pay(PayRequestVO payRequestVO) {

        String val = UUID.randomUUID().toString();

        try {

            // 基础参数校验
            ResponseErrorCodeEnum responseErrorCodeEnum = checkBasePayParam(payRequestVO, val);
            if (!Objects.isNull(responseErrorCodeEnum)) {
                return ResponseVO.paramError(responseErrorCodeEnum).build();
            }

            // 获取支付服务枚举
            PayServiceEnum payServiceEnum = PayServiceEnum.getPayServiceEnumByPaywayEnum(payRequestVO.getPaywayEnum());

            // 获取支付服务类
            Class<?> clazz = payServiceEnum.getClazz();
            PayService payService = (PayService) applicationContext.getBean(clazz);

            // 校验一下从数据库得到的支付配置
            BasePayConfigObj basePayConfigObj = castConfigObj(payRequestVO);
            if (Objects.isNull(basePayConfigObj)) {
                return null;
            }
            Object payErrorEnumObj = checkPayConfigObj(basePayConfigObj, payRequestVO);
            if (!Objects.isNull(payErrorEnumObj)) {
                return ResponseVO.configError(payErrorEnumObj).build();
            }

            String payNumber16 = payNumberUtil.generatePayNumber16();
            // 调用支付服务
            return payService.pay(payRequestVO, basePayConfigObj, payNumber16);
        } catch (Exception e) {
            log.info("pay exception ", e);
            return ResponseVO.fail(ResponseErrorCodeEnum.SYSTEM_ERROR).build();
        } finally {
            // 释放锁
            String key = payRequestVO.getMainOrderNumber() + ":" + payRequestVO.getMainFlowOrderNumber();
            lettuceRedisClient.releaseKey(key, val);
        }
    }

    private Object checkPayConfigObj(BasePayConfigObj basePayConfigObj, PayRequestVO payRequestVO) {

        if (basePayConfigObj instanceof WXPayConfigObj) {
            return (Object)checkWXPayConfigObj((WXPayConfigObj) basePayConfigObj, payRequestVO.getPayTerminalEnum());
        }

        return null;
    }

    private WXPayConfigCheckResponseEnum checkWXPayConfigObj(WXPayConfigObj basePayConfigObj, PayTerminalEnum payTerminalEnum) {

        if (StringUtils.isBlank(basePayConfigObj.getAppId())) {
            return WXPayConfigCheckResponseEnum.APPID_IS_NULL;
        }

        if (StringUtils.isBlank(basePayConfigObj.getMchId())) {
            return WXPayConfigCheckResponseEnum.MCH_ID_IS_NULL;
        }

        if (StringUtils.isBlank(basePayConfigObj.getPartnerKey())) {
            return WXPayConfigCheckResponseEnum.PARTNER_KEY_IS_NULL;
        }

        if (StringUtils.isBlank(basePayConfigObj.getCertPath())) {
            return WXPayConfigCheckResponseEnum.CERT_PATH_IS_NULL;
        }

        if (PayTerminalEnum.MICRO_PAY != payTerminalEnum) {
            if (StringUtils.isBlank(basePayConfigObj.getNotifyURL())) {
                return WXPayConfigCheckResponseEnum.NOTIFY_URL_IS_NULL;
            }
        }

        return null;
    }

    private BasePayConfigObj castConfigObj(PayRequestVO payRequestVO) {

        Map<String, String> configParamMap = payConfigService.getPayConfig(payRequestVO.getPaywayEnum(), payRequestVO.getPayTerminalEnum());
        if (Objects.isNull(configParamMap)) {
            return null;
        }

        PaywayEnum paywayEnum = payRequestVO.getPaywayEnum();
        switch (paywayEnum) {
            case WXPAY:
                return WXPayConfigObj.getConfig(configParamMap);
            default:
                return null;
        }

    }

    private ResponseErrorCodeEnum checkBasePayParam(PayRequestVO reqVO, String val) {

        if (StringUtils.isBlank(reqVO.getIp())) {
            return ResponseErrorCodeEnum.IP_IS_NULL;
        }

        if (Objects.isNull(reqVO.getPaywayEnum())) {
            return ResponseErrorCodeEnum.PAY_WAY_IS_NULL;
        }

        if (Objects.isNull(reqVO.getPayTerminalEnum())) {
            return ResponseErrorCodeEnum.PAY_TERMINAL_IS_NULL;
        }

        if (StringUtils.isBlank(reqVO.getSourceCode())) {
            return ResponseErrorCodeEnum.SOURCE_CODE_IS_NULL;
        }

        if (reqVO.getSourceCode().length() > 16) {
            return ResponseErrorCodeEnum.SOURCE_CODE_LENGTH_ERROR;
        }

        if (StringUtils.isBlank(reqVO.getSourceName())) {
            return ResponseErrorCodeEnum.SOURCE_NAME_IS_NULL;
        }

        if (reqVO.getSourceName().length() > 16) {
            return ResponseErrorCodeEnum.SOURCE_NAME_LENGTH_ERROR;
        }

        if (StringUtils.isBlank(reqVO.getMainOrderNumber())) {
            return ResponseErrorCodeEnum.MAIN_ORDER_NUMBER_IS_NULL;
        }

        if (reqVO.getMainOrderNumber().length() > 64) {
            return ResponseErrorCodeEnum.MAIN_ORDER_NUMBER_LENGTH_ERROR;
        }

        if (StringUtils.isBlank(reqVO.getMainFlowOrderNumber())) {
            return ResponseErrorCodeEnum.MAIN_FLOW_ORDER_NUMBER_IS_NULL;
        }

        if (reqVO.getMainFlowOrderNumber().length() > 64) {
            return ResponseErrorCodeEnum.MAIN_FLOW_ORDER_NUMBER_LENGTH_ERROR;
        }

        if (Objects.isNull(reqVO.getAmount())) {
            return ResponseErrorCodeEnum.AMOUNT_IS_NULL;
        }

        String amountStr = reqVO.getAmount().toPlainString();
        if (amountStr.contains(".")) {
            amountStr = amountStr.substring(amountStr.indexOf("."));
            if (amountStr.length() > 2) {
                return ResponseErrorCodeEnum.AMOUNT_FORMAT_ERROR;
            }
        }

        if (StringUtils.isBlank(reqVO.getGoodsBody())) {
            return ResponseErrorCodeEnum.GOODS_BODY_IS_NULL;
        }

        if (reqVO.getGoodsBody().length() > 64) {
            return ResponseErrorCodeEnum.GOODS_BODY_LENGTH_ERROR;
        }

        if (StringUtils.isBlank(reqVO.getTimeExpire())) {
            return ResponseErrorCodeEnum.TIME_EXPIRE_IS_NULL;
        }

        if (!reqVO.getTimeExpire().matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")) {
            return ResponseErrorCodeEnum.TIME_EXPIRE_FORMAT_ERROR;
        }


        return null;
    }



}
