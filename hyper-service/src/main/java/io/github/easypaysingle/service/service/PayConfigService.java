package io.github.easypaysingle.service.service;

import io.github.easypaysingle.common.enums.PayTerminalEnum;
import io.github.easypaysingle.common.enums.PaywayEnum;

import java.util.Map;

/**
 * 功能描述: 支付配置-接口
 *
 * @author hubao
 * @since 2024/4/1$ 15:45$
 */
public interface PayConfigService {


    /** 根据支付方式枚举、支付终端枚举获取支付配置
     * @param paywayEnum
     * @param payTerminalEnum
     * @return
     */
    Map<String, String> getPayConfig(PaywayEnum paywayEnum, PayTerminalEnum payTerminalEnum);
}
