package io.github.hyperpay.service.service;

import io.github.hyperpay.common.enums.PayTerminalEnum;
import io.github.hyperpay.common.enums.PaywayEnum;
import io.github.easypaysingle.core.config.BasePayConfigObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * 功能描述: 基础支付service-类 主要提供配置等
 *
 * @author hubao
 * @since 2024/4/1$ 15:46$
 */
@Component
public abstract class BasePayService {

    @Autowired
    private PayConfigService payConfigService;

    public BasePayConfigObj getPayConfig(PaywayEnum paywayEnum, PayTerminalEnum payTerminalEnum){

        Map<String, String> configMap = payConfigService.getPayConfig(paywayEnum, payTerminalEnum);
        if (!Objects.isNull(configMap)) {
            return null;
        }

        switch (paywayEnum) {
            case WXPAY:
                return null;
            default:
                return null;
        }
    }
}
