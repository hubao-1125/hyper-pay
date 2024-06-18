package io.github.hyperpay.common.model.vo.request;

import io.github.hyperpay.common.enums.PayTerminalEnum;
import io.github.hyperpay.common.enums.PaywayEnum;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 功能描述: 支付请求公共-类
 *
 * @author hubao
 * @since 2024/3/28$ 15:35$
 */
@Data
@SuperBuilder
public class PayRequestCommonVO implements Serializable {

    /**
     * ip地址
     * @DocView.Required
     */
    private String ip;

    /**
     * 支付方式枚举
     * @DocView.Required
     */
    private PaywayEnum paywayEnum;

    /**
     * 支付终端枚举
     * @DocView.Required
     */
    private PayTerminalEnum payTerminalEnum;

    /**
     * 来源系统编码
     * @DocView.Required
     */
    private String sourceCode;

    /**
     * 来源系统名称
     * @DocView.Required
     */
    private String sourceName;

    /**
     * 主订单号
     * @DocView.Required
     */
    private String mainOrderNumber;

    /**
     * 主流水号
     * @DocView.Required
     */
    private String mainFlowOrderNumber;

    /**
     * 支付金额 精确到小数点后2位
     * @DocView.Required
     */
    private BigDecimal amount;

    /**
     * 线下支付付款码 MICRO_PAY时必填
     */
    private String authCode;

    /**
     * 商品名称等信息
     * @DocView.Required
     */
    private String goodsBody;

    /**
     * 支付超时时间 最小为当前时间2分钟后自动关闭支付订单 格式：yyyy-MM-dd HH:mm:ss 京东支付可最小30秒
     * @DocView.Required
     */
    private String timeExpire;
}
