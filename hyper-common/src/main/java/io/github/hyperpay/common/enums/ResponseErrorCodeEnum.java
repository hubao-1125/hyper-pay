package io.github.hyperpay.common.enums;

import lombok.Getter;

/**
 * 功能描述: 支付错误码返回枚举-类
 *
 * @author hubao
 * @since 2024/4/1$ 14:53$
 */
@Getter
public enum ResponseErrorCodeEnum {


    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),
    THIRD_ERROR("THIRD_ERROR", "三方错误")


    ;

    private final String errorCode;
    private final String errorMsg;

    ResponseErrorCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
