package io.github.hyperpay.service.core.pay.config.wx;

import io.github.hyperpay.service.core.pay.config.BasePayConfigField;
import io.github.hyperpay.service.core.pay.config.BasePayConfigObj;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Map;

/**
 * 功能描述: 微信v2支付配置-类
 *
 * @author hubao
 * @since 2024/4/1$ 15:55$
 */
@Data
@SuperBuilder
public class WXPayConfigObj extends BasePayConfigObj implements Serializable {

    /**
     * appid
     */
    private String appId;

    /**
     * 子appid
     */
    private String subAppId;

    /**
     * 商户id
     */
    private String mchId;

    /**
     * 子商户ID
     */
    private String subMchId;

    /**
     * 密钥
     */
    private String partnerKey;

    /**
     * 退款证书地址
     */
    private String certPath;

    public static WXPayConfigObj getConfig(Map<String, String> configParamMap) {

        return WXPayConfigObj.builder()
                .appId(configParamMap.get(WXPayConfigField.APPID))
                .mchId(configParamMap.get(WXPayConfigField.MCH_ID))
                .subAppId(configParamMap.get(WXPayConfigField.SUB_APP_ID))
                .subMchId(configParamMap.get(WXPayConfigField.SUB_MCH_ID))
                .partnerKey(configParamMap.get(WXPayConfigField.PARTNER_KEY))
                .certPath(configParamMap.get(WXPayConfigField.CERT_PATH))
                .notifyURL(configParamMap.get(BasePayConfigField.NOTIFY_URL)).build();
    }
}
