package io.github.hyperpay.service.service.impl;

import io.github.hyperpay.common.enums.PayTerminalEnum;
import io.github.hyperpay.common.enums.ResponseErrorCodeEnum;
import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.request.pay.WXPayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;
import io.github.hyperpay.service.core.pay.client.PayClient;
import io.github.hyperpay.service.core.pay.config.BasePayConfigObj;
import io.github.hyperpay.service.core.pay.config.wx.WXPayConfigObj;
import io.github.hyperpay.service.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 功能描述: 微信v2支付-类
 *
 * @author hubao
 * @since 2024/4/1 15:45
 */
@Service
@Slf4j
public class WXPayServiceImpl implements PayService {





    @Override
    public ResponseVO pay(PayRequestVO payRequestVO, BasePayConfigObj payConfigObj, String payNumber) {

        // 校验微信支付参数
        ResponseErrorCodeEnum responseErrorCodeEnum = checkPayParam(payRequestVO);
        if (!Objects.isNull(responseErrorCodeEnum)) {
            return ResponseVO.paramError(responseErrorCodeEnum).build();
        }

        // 调用client支付
        ResponseVO responseVO = PayClient.builder().payNumber(payNumber).payRequestVO(payRequestVO)
                .payConfigObj(payConfigObj).build().pay();


        // 根据支付结果返回


        return null;
    }

    private ResponseErrorCodeEnum checkPayParam(PayRequestVO payRequestVO) {

        // 付款码支付
        if (PayTerminalEnum.MICRO_PAY == payRequestVO.getPayTerminalEnum()) {
            if (StringUtils.isBlank(payRequestVO.getAuthCode())) {
                return ResponseErrorCodeEnum.PAY_AUTH_CODE_IS_NULL;
            }
        }

        // 公众号和小程序判断openid
        if (PayTerminalEnum.PUBLIC_NUMBER == payRequestVO.getPayTerminalEnum() ||
                PayTerminalEnum.APPLET == payRequestVO.getPayTerminalEnum()) {
            WXPayRequestVO wxPayRequestVO = payRequestVO.getWxPayRequestVO();
            if (Objects.isNull(wxPayRequestVO)) {
                return ResponseErrorCodeEnum.WX_PAY_REQUEST_VO_IS_NULL;
            }

            if (StringUtils.isBlank(wxPayRequestVO.getOpenid())) {
                return ResponseErrorCodeEnum.WX_OPEN_ID_IS_NULL;
            }
        }


        return null;
    }
}
