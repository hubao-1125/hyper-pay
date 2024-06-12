package io.github.hyperpay.service.core.pay.client;

import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 功能描述: -类
 *
 * @author hubao
 * @since 2024/6/12 17:43
 */
@Data
@SuperBuilder
public class BaseClient {

    protected String payNumber;
    protected PayRequestVO payRequestVO;
}
