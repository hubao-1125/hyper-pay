package io.github.hyperpay.common.model.vo.response;

import lombok.Data;
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
public class ResponseCommonVO implements Serializable {

    // 返回信息↓
    /**
     * 返回码
     * @DocView.Required
     */
    protected String code;

    /**
     * 返回信息
     * @DocView.Required
     */
    protected String msg;

    /**
     * 错误码
     */
    protected String errorCode;

    /**
     * 错误信息
     */
    protected String errorMsg;

    // 支付参数↓
    /**
     * 支付订单号
     * @DocView.Required
     */
    protected String payOrderNumber;

    /**
     * 三方订单号
     * @DocView.Required
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
