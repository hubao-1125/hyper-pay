package io.github.easypaysingle.service.enums;

import io.github.hyperpay.common.enums.PaywayEnum;
import io.github.easypaysingle.service.service.impl.WXPayServiceImpl;
import lombok.Getter;

/**
 * 功能描述:  支付服务-枚举类
 *
 * @author hubao
 * @since: 2024/4/2 16:12
 */
@Getter
public enum PayServiceEnum {

    WX_PAY_SERVICE(PaywayEnum.WXPAY.getCode(), PaywayEnum.WXPAY, WXPayServiceImpl.class),

    ;
    /**
     * 支付方式编码
     */
    private String paywayCode;

    /**
     * 支付方式枚举
     */
    private PaywayEnum paywayEnum;

    /**
     * 实现类
     */
    private Class<?> clazz;

    PayServiceEnum(String paywayCode, PaywayEnum paywayEnum, Class<?> clazz) {
        this.paywayCode = paywayCode;
        this.paywayEnum = paywayEnum;
        this.clazz = clazz;
    }

    public static PayServiceEnum getPayServiceEnumByPaywayCode(String paywayCode) {
        for (PayServiceEnum payServiceEnum : PayServiceEnum.values()) {
            if (payServiceEnum.getPaywayCode().equals(paywayCode)) {
                return payServiceEnum;
            }
        }
        return null;
    }


    public static PayServiceEnum getPayServiceEnumByPaywayEnum(PaywayEnum paywayEnum) {
        for (PayServiceEnum payServiceEnum : PayServiceEnum.values()) {
            if (payServiceEnum.getPaywayEnum().equals(paywayEnum)) {
                return payServiceEnum;
            }
        }
        return null;
    }
}
