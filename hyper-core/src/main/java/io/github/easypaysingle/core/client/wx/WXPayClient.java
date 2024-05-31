package io.github.easypaysingle.core.client.wx;

import io.github.easypaysingle.core.config.BasePayConfigObj;
import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述: 微信v2支付-类
 *
 * @author hubao
 * @since 2024/4/1$ 15:54$
 */
@Slf4j
public class WXPayClient {


    public static ResponseVO pay(PayRequestVO payRequestVO, BasePayConfigObj payConfigObj) {

        switch (payRequestVO.getPayTerminalEnum()) {

            case H5:
                return h5(payRequestVO, payConfigObj);
            case PUBLIC_NUMBER:
                return null;
            case APPLET:
                return null;
            case APP:
                return null;
            case SCAN:
                return null;
            case MICRO_PAY:
                return null;
            default:
                return null;
        }
    }

    private static ResponseVO h5(PayRequestVO payRequestVO, BasePayConfigObj payConfigObj) {


        return null;
    }
}
