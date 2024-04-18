package io.github.hyperpay.common.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 功能描述:  支付返回码-枚举类
 *
 * @author hubao
 * @since 2024/4/1$ 14:52$
 */
@Getter
public enum ResponseCodeEnum {


    /**
     * 代表支付成功、退款受理成功、取消订单成功
     */
    SUCCESS("SUCCESS", "成功"),


    /**
     * 代表支付中、退款中、取消订单中
     */
    PROCESSING("PROCESSING", "处理中"),

    /**
     * 代表支付失败、退款失败、取消订单失败，具体看
     * @see ResponseErrorCodeEnum
     */
    FAIL("FAIL", "失败"),

    /**
     * 代表支付、退款、取消时入参错误，具体看
     * @see ResponseErrorCodeEnum
     */
    PARAM_ERROR("PARAM_ERROR", "参数错误"),

    /**
     * 代表支付、退款、取消时支付配置错误，具体看
     * @see ResponseErrorCodeEnum
     */
    CONFIG_ERROR("CONFIG_ERROR", "配置错误")
    ;

    private final String code;
    private final String msg;

    ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
