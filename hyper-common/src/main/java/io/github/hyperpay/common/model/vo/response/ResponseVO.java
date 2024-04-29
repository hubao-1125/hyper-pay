package io.github.hyperpay.common.model.vo.response;

import io.github.hyperpay.common.enums.ResponseCodeEnum;
import io.github.hyperpay.common.enums.ResponseErrorCodeEnum;
import io.github.hyperpay.common.enums.config.WXPayConfigCheckResponseEnum;
import io.github.hyperpay.common.model.vo.response.pay.WXPayResponseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

/**
 * 功能描述: 支付返回-类
 *
 * @author hubao
 * @since 2024/3/28$ 15:46$
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class ResponseVO extends ResponseCommonVO implements Serializable {

    /**
     * 微信v2支付返回VO
     */
    private WXPayResponseVO wxPayResponseVO;










    // ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓一些私有方法↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    private static ResponseVOBuilder createBuilder(ResponseCodeEnum responseCodeEnum) {
        return ResponseVO.builder().code(responseCodeEnum.getCode()).msg(responseCodeEnum.getMsg());
    }

    private static ResponseVOBuilder createBuilder(ResponseCodeEnum responseCodeEnum, Object errorEnum) {

        String errorMsg = "";
        String errorCode = "";

        if (errorEnum instanceof ResponseErrorCodeEnum) {
            errorCode = ((ResponseErrorCodeEnum) errorEnum).getErrorCode();
            errorMsg = ((ResponseErrorCodeEnum) errorEnum).getErrorMsg();
        } else if (errorEnum instanceof WXPayConfigCheckResponseEnum) {
            errorCode = ((WXPayConfigCheckResponseEnum) errorEnum).getErrorCode();
            errorMsg = ((WXPayConfigCheckResponseEnum) errorEnum).getErrorMsg();
        }

        return ResponseVO.builder().code(responseCodeEnum.getCode()).msg(responseCodeEnum.getMsg())
                .errorCode(errorCode).errorMsg(errorMsg);
    }

    public static ResponseVOBuilder success() {
        return createBuilder(ResponseCodeEnum.SUCCESS);
    }

    public static ResponseVOBuilder fail() {
        return createBuilder(ResponseCodeEnum.FAIL);
    }

    public static ResponseVOBuilder fail(ResponseErrorCodeEnum responseErrorCodeEnum) {
        return createBuilder(ResponseCodeEnum.FAIL, responseErrorCodeEnum);
    }

    public static ResponseVOBuilder processing() {
        return createBuilder(ResponseCodeEnum.PROCESSING);
    }

    public static ResponseVOBuilder configError(Object configCheckResponseEnum) {
        return createBuilder(ResponseCodeEnum.CONFIG_ERROR, configCheckResponseEnum);
    }

    public static ResponseVOBuilder paramError(ResponseErrorCodeEnum responseErrorCodeEnum) {
        return createBuilder(ResponseCodeEnum.PARAM_ERROR, responseErrorCodeEnum);
    }
}
