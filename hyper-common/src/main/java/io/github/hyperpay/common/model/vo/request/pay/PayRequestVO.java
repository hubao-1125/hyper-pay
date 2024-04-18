package io.github.hyperpay.common.model.vo.request.pay;

import io.github.hyperpay.common.model.vo.request.PayRequestCommonVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 功能描述: -类
 *
 * @author hubao
 * @since 2024/3/28 15:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class PayRequestVO extends PayRequestCommonVO implements Serializable {

    /**
     * 微信支付请求参数VO
     */
    private WXPayRequestVO wxPayRequestVO;
}
