package io.github.hyperpay.service.service;

import io.github.easypaysingle.core.config.BasePayConfigObj;
import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;

/**
 * 功能描述: 支付统一-接口
 *
 * @author hubao
 * @since 2024/4/1$ 15:40$
 */
public interface PayService {

    /**
     * 支付
     * @param payRequestVO pay request vo
     * @param payConfigObj pay config obj for child class
     * @return
     */
    ResponseVO pay(PayRequestVO payRequestVO, BasePayConfigObj payConfigObj);
}
