package io.github.hyperpay.common.model.vo.response.pay.wx;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
/**
 * 功能描述: 微信v2支付返回VO
 * @author hubao
 * @since: 2024/4/1 22:02
 */
public class WXPayResponseVO implements Serializable {

    /**
     * H5支付返回VO
     */
    private WXH5ResponseVO wxh5ResponseVO;
}
