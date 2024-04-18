package io.github.hyperpay.common.enums;

import lombok.Getter;

/**
 * 功能描述:  -枚举类
 *
 * @author hubao
 * @since 2024/4/18 17:55
 */
@Getter
public enum ParamErrorEnum {


    ;

    private final String errorCode;
    private final String errorMsg;

    ParamErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
