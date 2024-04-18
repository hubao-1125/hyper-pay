package io.github.hyperpay.common.facade;

import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;

/**
 * 功能描述: 支付-接口
 *
 * @author hubao
 * @since 2024/3/28$ 15:27$
 */
public interface PayFacade {


    /** 支付
     * @param payRequestVO 支付请求VO
     * @return ResponseVO
     */
    ResponseVO pay(PayRequestVO payRequestVO);
}
