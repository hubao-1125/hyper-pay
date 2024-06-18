package io.github.hyperpay.common.enums.config;

import lombok.Getter;

/**
 *
 * @author hubao
 * @since 2024/4/11 16:36
 */
@Getter
public enum WXPayConfigCheckResponseEnum {

    APPID_IS_NULL("APPID_IS_NULL", "appid为空，请检查支付配置"),
    MCH_ID_IS_NULL("MCH_ID_IS_NULL", "mchid为空，请检查支付配置"),
    SUB_APPID_IS_NULL("SUB_APPID_IS_NULL", "subappid为空，请检查支付配置"),
    SUB_MCH_ID_IS_NULL("SUB_MCH_ID_IS_NULL", "submchid为空，请检查支付配置"),
    PARTNER_KEY_IS_NULL("PARTNER_KEY_IS_NULL", "秘钥为空，请检查支付配置"),
    CERT_PATH_IS_NULL("CERT_PATH_IS_NULL", "退款证书不存在，请检查支付配置"),
    NOTIFY_URL_IS_NULL("NOTIFY_URL_IS_NULL", "异步回调地址为空，请检查支付配置"),
    NOTIFY_URL_IS_ERROR("NOTIFY_URL_IS_ERROR", "异步回调地址格式错误，请检查支付配置"),

    ;
    private final String errorCode;
    private final String errorMsg;

    WXPayConfigCheckResponseEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
