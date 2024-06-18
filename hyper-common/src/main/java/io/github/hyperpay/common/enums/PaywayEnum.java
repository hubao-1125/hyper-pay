package io.github.hyperpay.common.enums;

import lombok.Getter;

/**
 *
 * @author hubao
 * @since 2024/3/28$ 14:27$
 */
@Getter
public enum PaywayEnum {


    ALIPAY("ALIPAY", "alipay", "alipay_refund", "支付宝"),
    WXPAY("WXPAY", "wxpay", "wxpay_refund", "微信"),
    UNIONPAY("UNIONPAY", "unionpay", "unionpay_refund", "银联")

    ;

    private final String code;
    private final String payCode;
    private final String refundCode;
    private final String name;

    PaywayEnum(String code, String payCode, String refundCode, String name) {
        this.code = code;
        this.payCode = payCode;
        this.refundCode = refundCode;
        this.name = name;
    }

}
