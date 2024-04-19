package io.github.hyperpay.service.service;

import io.github.hyperpay.common.enums.ResponseErrorCodeEnum;
import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;
import io.github.hyperpay.service.core.LettuceRedisClient;
import io.github.hyperpay.service.enums.PayServiceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

/**
 * 功能描述: 支付工厂-类
 *
 * @author hubao
 * @since 2024/4/1$ 14:46$
 */
@Component
@Slf4j
public class PayFactory {


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private LettuceRedisClient lettuceRedisClient;


    public ResponseVO pay(PayRequestVO payRequestVO) {

        String val = UUID.randomUUID().toString();
        try {
            ResponseErrorCodeEnum responseErrorCodeEnum = checkBasePayParam(payRequestVO, val);
            if (!Objects.isNull(responseErrorCodeEnum)) {
                return ResponseVO.paramError(responseErrorCodeEnum).build();
            }

            // 获取支付服务枚举
            PayServiceEnum payServiceEnum = PayServiceEnum.getPayServiceEnumByPaywayEnum(payRequestVO.getPaywayEnum());

            // 获取支付服务类
            Class<?> clazz = payServiceEnum.getClazz();
            PayService payService = (PayService) applicationContext.getBean(clazz);
            // 调用支付服务
            return payService.pay(payRequestVO);
        } catch (Exception e) {
            log.info("pay exception ", e);
            return ResponseVO.fail(ResponseErrorCodeEnum.SYSTEM_ERROR).build();
        } finally {
            // 释放锁
            String key = payRequestVO.getMainOrderNumber() + ":" + payRequestVO.getMainFlowOrderNumber();
            lettuceRedisClient.releaseKey(key, val);
        }
    }

    private ResponseErrorCodeEnum checkBasePayParam(PayRequestVO payRequestVO, String val) {

        payRequestVO.getIp();

        return null;
    }



}