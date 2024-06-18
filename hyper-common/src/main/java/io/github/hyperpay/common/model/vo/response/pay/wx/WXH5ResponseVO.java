package io.github.hyperpay.common.model.vo.response.pay.wx;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/*
 * 微信H5返回VO
 *
 * @author hubao
 * @since 2024/6/18 17:05
 */
@Data
@Builder
public class WXH5ResponseVO implements Serializable {

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 预支付交易会话标识
     */
    private String prepayId;

    /**
     * 支付跳转链接
     */
    private String webURL;
}
