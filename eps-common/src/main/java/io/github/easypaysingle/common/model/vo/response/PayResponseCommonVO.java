package io.github.easypaysingle.common.model.vo.response;

import io.github.easypaysingle.common.enums.ResponseCodeEnum;
import io.github.easypaysingle.common.enums.ResponseErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 功能描述: 支付返回公共-类
 *
 * @author hubao
 * @since 2024/3/28$ 15:44$
 */
@Data
@SuperBuilder
public class PayResponseCommonVO implements Serializable {

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回码枚举
     */
    private ResponseCodeEnum responseCodeEnum;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 错误码枚举
     */
    private ResponseErrorCodeEnum responseErrorCodeEnum;
}
