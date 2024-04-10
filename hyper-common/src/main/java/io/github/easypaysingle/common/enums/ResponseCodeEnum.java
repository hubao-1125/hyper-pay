package io.github.easypaysingle.common.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 功能描述:  支付返回码-枚举类
 *
 * @author hubao
 * @since 2024/4/1$ 14:52$
 */
@Getter
public enum ResponseCodeEnum {


    /*
    *
    * =======支付
    * 支付成功
    * 支付中
    * 支付失败
    *
    * =======参数
    * 参数错误
    *
    * =======查询
    * 查询失败
    *
    * =======退款
    * 退款成功
    * 退款中
    * 退款失败
    *
    * =======撤单
    * 撤单成功
    * 撤单中
    * 撤单失败
    *
    *
    * */

    SUCCESS("SUCCESS", "成功"),
    PROCESSING("PROCESSING", "处理中"),
    FAIL("FAIL", "失败"),
    PARAM_ERROR("PARAM_ERROR", "参数错误"),
    CONFIG_ERROR("CONFIG_ERROR", "配置错误")
    ;

    private final String code;
    private final String msg;

    ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
