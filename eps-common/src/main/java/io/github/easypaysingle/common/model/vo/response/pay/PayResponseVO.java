package io.github.easypaysingle.common.model.vo.response.pay;

import io.github.easypaysingle.common.model.vo.response.PayResponseCommonVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 功能描述: 支付返回-类
 *
 * @author hubao
 * @since 2024/3/28$ 15:46$
 */
@Data
@SuperBuilder
public class PayResponseVO extends PayResponseCommonVO implements Serializable {
}
