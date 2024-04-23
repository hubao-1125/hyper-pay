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
    THIRD_ERROR("THIRD_ERROR", "三方错误"),
    IP_IS_NULL("IP_IS_NULL", "IP地址不可以为空"),
    PAY_WAY_IS_NULL("PAY_WAY_IS_NULL", "支付方式不可以为空"),
    PAY_TERMINAL_IS_NULL("PAY_TERMINAL_IS_NULL", "支付终端不可以为空"),
    SOURCE_CODE_IS_NULL("SOURCE_CODE_IS_NULL", "来源系统编码不可以为空"),
    SOURCE_CODE_LENGTH_ERROR("SOURCE_CODE_LENGTH_ERROR", "来源系统编码长度错误"),
    SOURCE_NAME_IS_NULL("SOURCE_NAME_IS_NULL", "来源系统名称不可以为空"),
    SOURCE_NAME_LENGTH_ERROR("SOURCE_NAME_LENGTH_ERROR", "来源系统名称长度错误"),
    MAIN_ORDER_NUMBER_IS_NULL("MAIN_ORDER_NUMBER_IS_NULL", "主订单号不可以为空"),
    MAIN_ORDER_NUMBER_LENGTH_ERROR("MAIN_ORDER_NUMBER_LENGTH_ERROR", "主订单号长度错误"),
    MAIN_FLOW_ORDER_NUMBER_IS_NULL("MAIN_FLOW_ORDER_NUMBER_IS_NULL", "主流水号不可以为空"),
    MAIN_FLOW_ORDER_NUMBER_LENGTH_ERROR("MAIN_FLOW_ORDER_NUMBER_LENGTH_ERROR", "主流水号长度错误"),
    AMOUNT_IS_NULL("AMOUNT_IS_NULL", "支付金额不可以为空"),
    AMOUNT_FORMAT_ERROR("AMOUNT_FORMAT_ERROR", "支付金额错误"),
    GOODS_BODY_IS_NULL("GOODS_BODY_IS_NULL", "商品名称不可以为空"),
    GOODS_BODY_LENGTH_ERROR("GOODS_BODY_LENGTH_ERROR", "商品名称长度错误"),
    TIME_EXPIRE_IS_NULL("TIME_EXPIRE_IS_NULL", "支付超时时间不可以为空"),
    TIME_EXPIRE_FORMAT_ERROR("TIME_EXPIRE_FORMAT_ERROR", "支付超时时间格式错误"),
    PAY_AUTH_CODE_IS_NULL("PAY_AUTH_CODE_IS_NULL", "付款码不可以为空"),
    WX_PAY_REQUEST_VO_IS_NULL("WX_PAY_REQUEST_VO_IS_NULL", "微信支付请求参数不可以为空"),
    WX_OPEN_ID_IS_NULL("WX_OPEN_ID_IS_NULL", "openid不可以为空")

    ;

    private final String errorCode;
    private final String errorMsg;

    ResponseErrorCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
