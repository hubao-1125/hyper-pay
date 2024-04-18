package io.github.easypaysingle.service.service.impl;

import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;
import io.github.easypaysingle.service.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 功能描述: 微信v2支付-类
 *
 * @author hubao
 * @since 2024/4/1 15:45
 */
@Service
@Slf4j
public class WXPayServiceImpl implements PayService {




    @Override
    public ResponseVO pay(PayRequestVO payRequestVO) {
        return null;
    }
}
