package io.github.easypaysingle.common.model.vo.request.pay;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述: 微信v2支付请求-类
 *
 * @author hubao
 * @Date: 2024/3/29$ 16:49$
 */
@Data
@Builder
public class WXPayRequestVO implements Serializable {

    /**
     * openid
     */
    private String openid;
}
