package io.github.easypaysingle.core.client.wx;

import com.ijpay.core.enums.SignType;
import com.ijpay.core.kit.WxPayKit;
import com.ijpay.wxpay.WxPayApi;
import com.ijpay.wxpay.model.UnifiedOrderModel;
import io.github.easypaysingle.core.config.wx.WXPayConfigObj;
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


    public static ResponseVO pay(PayRequestVO payRequestVO, WXPayConfigObj payConfigObj) {

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

    private static ResponseVO h5(PayRequestVO payRequestVO, WXPayConfigObj payConfigObj) {

        UnifiedOrderModel build = UnifiedOrderModel.builder()
                .appid(payConfigObj.getAppId()).mch_id(payConfigObj.getMchId())
                .nonce_str(WxPayKit.generateStr()).sign_type(SignType.HMACSHA256.getType())
                .body(payRequestVO.getGoodsBody()).out_trade_no(payRequestVO.getMainOrderNumber())
                .total_fee(payRequestVO.getAmount().multiply(new BigDecimal(100)).intValue())
                .spbill_create_ip(payRequestVO.getIp())
                .notify_url(payConfigObj.getNotifyURL())
                .trade_type("MWEB")
                .product_id(payRequestVO.getMainOrderNumber())
                .build();

        WxPayApi.pushOrder(false, build.toMap());



        return null;
    }
}
