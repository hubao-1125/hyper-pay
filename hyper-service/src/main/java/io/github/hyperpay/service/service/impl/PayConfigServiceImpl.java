package io.github.hyperpay.service.service.impl;

import io.github.hyperpay.common.enums.PayTerminalEnum;
import io.github.hyperpay.common.enums.PaywayEnum;
import io.github.hyperpay.service.mapper.ConfigParamMapper;
import io.github.hyperpay.service.model.po.ConfigParamPO;
import io.github.hyperpay.service.service.PayConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 功能描述: -类
 *
 * @author hubao
 * @since 2024/4/1$ 15:46$
 */
@Service
public class PayConfigServiceImpl implements PayConfigService {


    @Autowired
    private ConfigParamMapper configParamMapper;

    @Override
    public Map<String, String> getPayConfig(PaywayEnum paywayEnum, PayTerminalEnum payTerminalEnum) {

        if (Objects.isNull(paywayEnum) || Objects.isNull(payTerminalEnum)) {
            return null;
        }

        List<ConfigParamPO> configParamPOList = configParamMapper.selectList(ConfigParamPO.builder()
                .paywayCode(paywayEnum.getCode()).payTerminalCode(payTerminalEnum.getUpperCode()).build());



        return null;
    }

}
