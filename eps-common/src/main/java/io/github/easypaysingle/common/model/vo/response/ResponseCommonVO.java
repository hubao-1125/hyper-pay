package io.github.easypaysingle.common.model.vo.response;

import io.github.easypaysingle.common.enums.ResponseCodeEnum;
import io.github.easypaysingle.common.enums.ResponseErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 功能描述: 返回公共-类
 *
 * @author hubao
 * @since 2024/3/28 15:44
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class ResponseCommonVO implements Serializable {

    // 返回信息↓
    /**
     * 返回码
     */
    protected String code;

    /**
     * 返回信息
     */
    protected String msg;

    /**
     * 返回码枚举
     */
    protected ResponseCodeEnum responseCodeEnum;

    /**
     * 错误码
     */
    protected String errorCode;

    /**
     * 错误信息
     */
    protected String errorMsg;

    /**
     * 错误码枚举
     */
    protected ResponseErrorCodeEnum responseErrorCodeEnum;


    // 支付参数↓
    /**
     * 支付订单号
     */
    protected String payOrderNumber;

    /**
     * 三方订单号
     */
    protected String thirdOrderNumber;

    // 退款参数↓
    /**
     * 退款订单号
     */
    protected String refundOrderNumber;

    /**
     * 三方退款订单号
     */
    protected String thirdRefundOrderNumber;

    // 撤销参数↓
    /**
     * 撤销订单号
     */
    protected String cancelOrderNumber;
}