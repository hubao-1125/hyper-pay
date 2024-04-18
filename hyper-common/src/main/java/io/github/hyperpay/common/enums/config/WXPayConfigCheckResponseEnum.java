package io.github.hyperpay.common.enums.config;

import lombok.Getter;

/**
 * 功能描述:  微信支付配置检查返回-枚举类
 *
 * @author hubao
 * @since 2024/4/11 16:36
 */
@Getter
public enum WXPayConfigCheckResponseEnum {


    ;
    private final String errorCode;
    private final String errorMsg;

    WXPayConfigCheckResponseEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
