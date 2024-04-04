package io.github.easypaysingle.core.config.wx;

import io.github.easypaysingle.core.config.BasePayConfigObj;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 功能描述: 微信v2支付配置-类
 *
 * @author hubao
 * @since 2024/4/1$ 15:55$
 */
@Data
@SuperBuilder
public class WXPayConfigObj extends BasePayConfigObj implements Serializable {
}
