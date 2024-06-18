package io.github.hyperpay.service.core.pay.constant;

import lombok.Data;

import java.io.Serializable;

/*
 * wx v2 pay response param constant obj
 *
 * @author hubao
 * @since 2024/6/18 16:05
 */
@Data
public class WXPayConstantObj implements Serializable {

    private String return_code;
    private String return_msg;
    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String trade_type;
    private String prepay_id;
    private String mweb_url;
}
