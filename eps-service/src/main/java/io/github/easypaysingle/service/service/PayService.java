package io.github.easypaysingle.service.service;

import io.github.easypaysingle.common.model.vo.request.pay.PayRequestVO;
import io.github.easypaysingle.common.model.vo.response.pay.PayResponseVO;

/**
 * 功能描述: 支付统一-接口
 *
 * @author hubao
 * @since 2024/4/1$ 15:40$
 */
public interface PayService {

    /** 支付
     * @param payRequestVO
     * @return
     */
    PayResponseVO pay(PayRequestVO payRequestVO);
}