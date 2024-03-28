package io.github.easypaysingle.common.enums;

/**
 * 功能描述:  支付方式-枚举类
 *
 * @author hubao
 * @Date: 2024/3/28$ 14:27$
 */
public enum PaywayEnum {


    ALIPAY("ALIPAY", "alipay", "alipay_refund", "支付宝"),
    WXPAY("WXPAY", "wxpay", "wxpay_refund", "微信"),
    UNIONPAY("UNIONPAY", "unionpay", "unionpay_refund", "银联")

    ;

    private String code;
    private String payCode;
    private String refundCode;
    private String name;

    PaywayEnum(String code, String payCode, String refundCode, String name) {
        this.code = code;
        this.payCode = payCode;
        this.refundCode = refundCode;
        this.name = name;
    }

    PaywayEnum() {
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getRefundCode() {
        return refundCode;
    }

    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
