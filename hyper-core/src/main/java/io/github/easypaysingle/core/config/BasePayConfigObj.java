package io.github.easypaysingle.core.config;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 功能描述: 基础支付配置obj-类
 *
 * @author hubao
 * @since 2024/4/1 15:56
 */
@Data
@SuperBuilder
public class BasePayConfigObj implements Serializable {

    /**
     * 支付请求域名
     */
    private String payRequestURL;

    /**
     * 退款请求域名
     */
    private String refundRequestURL;

    /**
     * 查询订单请求域名
     */
    private String queryRequestURL;

    /**
     * 撤单请求URL
     */
    private String cancelRequestURL;

    /**
     * 异步回调地址
     */
    private String notifyURL;

}
