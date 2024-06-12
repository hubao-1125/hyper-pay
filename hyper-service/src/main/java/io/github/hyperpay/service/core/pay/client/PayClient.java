package io.github.hyperpay.service.core.pay.client;

import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;
import io.github.hyperpay.service.core.pay.client.wx.WXPayClient;
import io.github.hyperpay.service.core.pay.config.BasePayConfigObj;
import io.github.hyperpay.service.core.pay.config.wx.WXPayConfigObj;

/**
 * 功能描述: 支付客户端-类
 *
 * @author hubao
 * @since 2024/5/31 17:18
 */
public class PayClient {
    public static ResponseVO pay(PayRequestVO payRequestVO, BasePayConfigObj payConfigObj) {


        switch (payRequestVO.getPaywayEnum()) {
            case WXPAY:
                return WXPayClient.pay(payRequestVO, (WXPayConfigObj) payConfigObj);
            case ALIPAY:
                return null;
            case UNIONPAY:
                return null;
            default:
                return null;
        }
    }
}
