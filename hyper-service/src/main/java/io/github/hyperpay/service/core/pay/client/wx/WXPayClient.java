package io.github.hyperpay.service.core.pay.client.wx;

import cn.hutool.json.JSONUtil;
import com.ijpay.core.enums.SignType;
import com.ijpay.core.kit.WxPayKit;
import com.ijpay.wxpay.WxPayApi;
import com.ijpay.wxpay.model.UnifiedOrderModel;
import io.github.hyperpay.common.enums.PayTerminalEnum;
import io.github.hyperpay.common.enums.PaywayEnum;
import io.github.hyperpay.common.enums.ResponseErrorCodeEnum;
import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;
import io.github.hyperpay.common.model.vo.response.pay.wx.WXH5ResponseVO;
import io.github.hyperpay.common.model.vo.response.pay.wx.WXPayResponseVO;
import io.github.hyperpay.common.utils.ConstantUtil;
import io.github.hyperpay.service.core.pay.client.BaseClient;
import io.github.hyperpay.service.core.pay.config.wx.WXPayConfigObj;
import io.github.hyperpay.service.core.pay.constant.WXPayConstantObj;
import io.github.hyperpay.service.utils.MoneyUtil;
import io.github.hyperpay.service.utils.wx.WXConstantUtil;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 功能描述: 微信v2支付-类
 *
 * @author hubao
 * @since 2024/4/1$ 15:54$
 */
@Data
@SuperBuilder
@Slf4j
public class WXPayClient extends BaseClient {

    private WXPayConfigObj wxPayConfigObj;

    public ResponseVO pay() {

        switch (payRequestVO.getPayTerminalEnum()) {

            case H5:
                return h5(payRequestVO, wxPayConfigObj);
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


        Map<String, String> sceneMap = new HashMap<String, String>(){{
            put("type", "Wap");
            put("wap_url", payConfigObj.getNotifyURL());
            put("wap_name", "pay_center");
        }};
        UnifiedOrderModel build = getUnifiedOrderBuilder(payRequestVO, payConfigObj)
                .trade_type(WXConstantUtil.H5)
                .scene_info(JSONUtil.createObj().set("h5_info", sceneMap).toString())
                .build();

        WXPayConstantObj constantObj = wxCommonRequest(payConfigObj, build, PayTerminalEnum.H5);
        ResponseVO responseVO = wxCommonCodeCheck(constantObj);
        if (!Objects.isNull(responseVO)) {
            return responseVO;
        }

        return ResponseVO.success().wxPayResponseVO(
                WXPayResponseVO.builder()
                        .wxh5ResponseVO(
                                WXH5ResponseVO.builder()
                                        .tradeType(constantObj.getTrade_type())
                                        .prepayId(constantObj.getPrepay_id())
                                        .webURL(constantObj.getMweb_url())
                                        .build()
                        )
                        .build()
        ).build();
    }

    private static UnifiedOrderModel.UnifiedOrderModelBuilder getUnifiedOrderBuilder(PayRequestVO payRequestVO,
                                                                                     WXPayConfigObj payConfigObj) {
        return UnifiedOrderModel.builder()
                .appid(payConfigObj.getAppId())
                .mch_id(payConfigObj.getMchId())
                .nonce_str(WxPayKit.generateStr())
                .sign_type(SignType.HMACSHA256.getType())
                .body(payRequestVO.getGoodsBody())
                .out_trade_no(payRequestVO.getMainOrderNumber())
                .total_fee(MoneyUtil.castBigDecimalToPoint(payRequestVO.getAmount()).toString())
                .spbill_create_ip(payRequestVO.getIp())
                .notify_url(payConfigObj.getNotifyURL() + ConstantUtil.NOTIFY + ConstantUtil.LEFT_SLASH + ConstantUtil.PAY + PaywayEnum.WXPAY.getPayCode())
                ;
    }

    private static ResponseVO wxCommonCodeCheck(WXPayConstantObj constantObj) {

        if (Objects.isNull(constantObj)) {
            return ResponseVO.fail(ResponseErrorCodeEnum.WX_RES_IS_NULL).build();
        }
        // return_code
        if (!WxPayKit.codeIsOk(constantObj.getReturn_code())) {
            return ResponseVO.fail().errorCode(constantObj.getReturn_code()).errorMsg(constantObj.getReturn_msg()).build();
        }
        // result_code
        if (!WxPayKit.codeIsOk(constantObj.getResult_code())) {
            return ResponseVO.fail().errorCode(constantObj.getErr_code()).errorMsg(constantObj.getErr_code_des()).build();
        }

        return null;
    }

    private static WXPayConstantObj wxCommonRequest(WXPayConfigObj payConfigObj, Object object, PayTerminalEnum payTerminalEnum) {

        if (object instanceof UnifiedOrderModel) {
            return wxCommonRequestUnifiedOrder(payConfigObj, (UnifiedOrderModel) object, payTerminalEnum);
        }

        return null;
    }

    private static WXPayConstantObj wxCommonRequestUnifiedOrder(WXPayConfigObj payConfigObj, UnifiedOrderModel build, PayTerminalEnum payTerminalEnum) {


        switch (payTerminalEnum) {
            case H5:
                return wxCommonRequestUnifiedOrderH5(payConfigObj, build, payTerminalEnum);
            default:
                return null;
        }

    }

    private static WXPayConstantObj wxCommonRequestUnifiedOrderH5(WXPayConfigObj payConfigObj, UnifiedOrderModel build, PayTerminalEnum payTerminalEnum) {

        Map<String, String> paramMap = build.createSign(payConfigObj.getPartnerKey(), SignType.HMACSHA256);
        log.info("WXPayClient h5 pay req paramMap:{}", paramMap);
        String xmlResult = WxPayApi.pushOrder(false, paramMap);
        log.info("WXPayClient h5 pay res xmlResult:{}", xmlResult);
        return JSONUtil.parseObj(WxPayKit.xmlToMap(xmlResult)).toBean(WXPayConstantObj.class);
    }
}
