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
     */
    private String ip;

    /**
     * 支付方式枚举
     */
    private PaywayEnum paywayEnum;

    /**
     * 支付终端枚举
     */
    private PayTerminalEnum payTerminalEnum;

    /**
     * 来源系统编码
     */
    private String sourceCode;

    /**
     * 来源系统名称
     */
    private String sourceName;

    /**
     * 主订单号
     */
    private String mainOrderNumber;

    /**
     * 主流水号
     */
    private String mainFlowOrderNumber;

    /**
     * 支付金额
     */
    private BigDecimal amount;

    /**
     * 线下支付付款码
     */
    private String authCode;

    /**
     * 商品名称等信息
     */
    private String goodsBody;

    /**
     * 支付超时时间 最小为当前时间2分钟后自动关闭支付订单 格式：yyyy-MM-dd HH:mm:ss 京东支付可最小30秒
     */
    private String timeExpire;
}
