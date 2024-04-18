package io.github.hyperpay.common.enums;

import lombok.Getter;

/**
 * 功能描述:  支付终端-枚举类
 *
 * @author hubao
 * @since 2024/3/28 14:44
 */
@Getter
public enum PayTerminalEnum {

    H5("H5", "h5",  "h5"),

    /**
     * APP支付
     */
    APP("APP", "app", "app"),

    /**
     * PC主扫
     */
    SCAN("SCAN", "scan", "PC主扫"),

    /**
     * 小程序支付
     */
    APPLET("APPLET", "applet", "小程序"),

    /**
     * 公众号支付
     */
    PUBLIC_NUMBER("PUBLIC_NUMBER", "public_number", "公众号支付"),

    /**
     * 付款码线下支付
     */
    MICRO_PAY("MICRO_PAY", "micro_pay", "付款码线下支付"),


    ;


    private final String upperCode;
    private final String lowerCode;
    private final String name;

    PayTerminalEnum(String upperCode, String lowerCode, String name) {
        this.upperCode = upperCode;
        this.lowerCode = lowerCode;
        this.name = name;
    }


}
