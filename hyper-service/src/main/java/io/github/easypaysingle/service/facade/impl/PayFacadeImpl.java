package io.github.easypaysingle.service.facade.impl;

import io.github.easypaysingle.common.facade.PayFacade;
import io.github.easypaysingle.common.model.vo.request.pay.PayRequestVO;
import io.github.easypaysingle.common.model.vo.response.ResponseVO;
import io.github.easypaysingle.service.service.PayFactory;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 功能描述: -类
 *
 * @author hubao
 * @since 2024/4/1$ 13:48$
 */
@DubboService(version = "1.0.0", interfaceClass = PayFacade.class)
public class PayFacadeImpl implements PayFacade {


    @Autowired
    private PayFactory payFactory;

    @Override
    public ResponseVO pay(PayRequestVO payRequestVO) {
        return payFactory.pay(payRequestVO);
    }

}
