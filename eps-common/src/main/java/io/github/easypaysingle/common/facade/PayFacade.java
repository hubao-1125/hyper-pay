package io.github.easypaysingle.common.facade;

import io.github.easypaysingle.common.model.vo.request.pay.PayRequestVO;
import io.github.easypaysingle.common.model.vo.response.pay.PayResponseVO;

/**
 * 功能描述: 支付-接口
 *
 * @author hubao
 * @Date: 2024/3/28$ 15:27$
 */
public interface PayFacade {


    /** 支付
     * @param payRequestVO
     * @return
     */
    PayResponseVO pay(PayRequestVO payRequestVO);
}
