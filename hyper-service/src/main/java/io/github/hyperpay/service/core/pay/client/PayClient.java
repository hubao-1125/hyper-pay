package io.github.hyperpay.service.core.pay.client;

import io.github.hyperpay.common.model.vo.response.ResponseVO;
import io.github.hyperpay.service.core.pay.client.wx.WXPayClient;
import io.github.hyperpay.service.core.pay.config.BasePayConfigObj;
import io.github.hyperpay.service.core.pay.config.wx.WXPayConfigObj;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 功能描述: 支付客户端-类
 *
 * @author hubao
 * @since 2024/5/31 17:18
 */
@Data
@SuperBuilder
public class PayClient extends BaseClient{

    private BasePayConfigObj payConfigObj;



    // ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓method↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    public ResponseVO pay() {


        switch (payRequestVO.getPaywayEnum()) {
            case WXPAY:
                return WXPayClient.builder().payNumber(payNumber).wxPayConfigObj((WXPayConfigObj) payConfigObj).build().pay();
            case ALIPAY:
                return null;
            case UNIONPAY:
                return null;
            default:
                return null;
        }
    }
}
