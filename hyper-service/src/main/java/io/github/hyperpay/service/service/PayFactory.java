package io.github.hyperpay.service.service;

import io.github.easypaysingle.core.config.BasePayConfigObj;
import io.github.hyperpay.common.enums.ResponseErrorCodeEnum;
import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;
import io.github.hyperpay.service.core.LettuceRedisClient;
import io.github.hyperpay.service.enums.PayServiceEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

/**
 * 功能描述: 支付工厂-类
 *
 * @author hubao
 * @since 2024/4/1$ 14:46$
 */
@Component
@Slf4j
public class PayFactory {


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private LettuceRedisClient lettuceRedisClient;

    @Autowired
    private PayConfigService payConfigService;


    public ResponseVO pay(PayRequestVO payRequestVO) {

        String val = UUID.randomUUID().toString();
        try {
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

            // 调用支付服务
            return payService.pay(payRequestVO, BasePayConfigObj.builder().build());
        } catch (Exception e) {
            log.info("pay exception ", e);
            return ResponseVO.fail(ResponseErrorCodeEnum.SYSTEM_ERROR).build();
        } finally {
            // 释放锁
            String key = payRequestVO.getMainOrderNumber() + ":" + payRequestVO.getMainFlowOrderNumber();
            lettuceRedisClient.releaseKey(key, val);
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
