package io.github.easypaysingle.common.model.vo.response;

import io.github.easypaysingle.common.enums.ResponseCodeEnum;
import io.github.easypaysingle.common.enums.ResponseErrorCodeEnum;
import io.github.easypaysingle.common.model.vo.response.pay.WXPayResponseVO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 功能描述: 支付返回-类
 *
 * @author hubao
 * @since 2024/3/28$ 15:46$
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class ResponseVO extends ResponseCommonVO implements Serializable {

    /**
     * 微信v2支付返回VO
     */
    private WXPayResponseVO wxPayResponseVO;


    @Builder(builderMethodName = "childBuilder", toBuilder = true)
    public ResponseVO(String code, String msg, ResponseCodeEnum responseCodeEnum,
                      String errorCode, String errorMsg, ResponseErrorCodeEnum responseErrorCodeEnum,
                      String payOrderNumber, String thirdOrderNumber,
                      String refundOrderNumber, String thirdRefundOrderNumber,
                      String cancelOrderNumber,
                      WXPayResponseVO wxPayResponseVO) {

        super.setCode(code);
        super.setMsg(msg);
        super.setResponseCodeEnum(responseCodeEnum);
        super.setErrorCode(errorCode);
        super.setErrorMsg(errorMsg);
        super.setResponseErrorCodeEnum(responseErrorCodeEnum);
        super.setPayOrderNumber(payOrderNumber);
        super.setThirdOrderNumber(thirdOrderNumber);
        super.setRefundOrderNumber(refundOrderNumber);
        super.setThirdRefundOrderNumber(thirdRefundOrderNumber);
        super.setCancelOrderNumber(cancelOrderNumber);

        this.wxPayResponseVO = wxPayResponseVO;

    }


    /*
    *
    * 成功
    * 失败
    * 处理中
    * 参数错误
    * 配置错误
    *
    * */

    /**
     * 功能描述: 成功
     * @return io.github.easypaysingle.common.model.vo.response.ResponseVO.ResponseVOBuilder
     * @author hubao
     * @since 2024/4/1 23:02
     */
    public static ResponseVO.ResponseVOBuilder success() {
        return childBuilder().code(ResponseCodeEnum.SUCCESS.getCode()).msg(ResponseCodeEnum.SUCCESS.getMsg());
    }

    /**
     * 功能描述: 失败
     * @return io.github.easypaysingle.common.model.vo.response.ResponseVO.ResponseVOBuilder
     * @author hubao
     * @since 2024/4/1 23:10
     */
    public static ResponseVO.ResponseVOBuilder fail() {
        return childBuilder().code(ResponseCodeEnum.FAIL.getCode()).msg(ResponseCodeEnum.FAIL.getMsg());
    }

    /**
     * 功能描述: 处理中
     * @return io.github.easypaysingle.common.model.vo.response.ResponseVO.ResponseVOBuilder
     * @author hubao
     * @since 2024/4/1 23:12
     */
    public static ResponseVO.ResponseVOBuilder processing() {
        return childBuilder().code(ResponseCodeEnum.PROCESSING.getCode()).msg(ResponseCodeEnum.PROCESSING.getMsg());
    }

    /**
     * 功能描述: 参数错误
     * @param responseErrorCodeEnum 支付错误码返回枚举
     * @return io.github.easypaysingle.common.model.vo.response.ResponseVO.ResponseVOBuilder
     * @author hubao
     * @since 2024/4/1 23:14
     */
    public static ResponseVO.ResponseVOBuilder paramError(ResponseErrorCodeEnum responseErrorCodeEnum) {
        return childBuilder().code(ResponseCodeEnum.PARAM_ERROR.getCode()).msg(ResponseCodeEnum.PARAM_ERROR.getMsg())
                .errorCode(responseErrorCodeEnum.getErrorCode()).errorMsg(responseErrorCodeEnum.getErrorMsg());
    }

    /**
     * 功能描述: 配置错误
     * @param responseErrorCodeEnum 支付错误码返回枚举
     * @return io.github.easypaysingle.common.model.vo.response.ResponseVO.ResponseVOBuilder
     * @author hubao
     * @since 2024/4/1 23:14
     */
    public static ResponseVO.ResponseVOBuilder configError(ResponseErrorCodeEnum responseErrorCodeEnum) {
        return childBuilder().code(ResponseCodeEnum.CONFIG_ERROR.getCode()).msg(ResponseCodeEnum.CONFIG_ERROR.getMsg())
                .errorCode(responseErrorCodeEnum.getErrorCode()).errorMsg(responseErrorCodeEnum.getErrorMsg());
    }
}
