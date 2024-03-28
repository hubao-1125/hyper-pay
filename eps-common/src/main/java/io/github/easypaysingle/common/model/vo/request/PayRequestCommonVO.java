package io.github.easypaysingle.common.model.vo.request;

import io.github.easypaysingle.common.enums.PayTerminalEnum;
import io.github.easypaysingle.common.enums.PaywayEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述: 支付请求公共-类
 *
 * @author hubao
 * @Date: 2024/3/28$ 15:35$
 */
@Data
@Builder
public class PayRequestCommonVO implements Serializable {

    private String ip;

    private PaywayEnum paywayEnum;

    private PayTerminalEnum payTerminalEnum;
}
