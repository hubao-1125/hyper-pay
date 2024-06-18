package io.github.hyper.pay.controller;

import io.github.hyperpay.common.utils.ConstantUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *
 *
 * @author hubao
 * @since 2024/6/18 15:38
 */
@RestController
@RequestMapping(ConstantUtil.LEFT_SLASH + ConstantUtil.NOTIFY)
public class NotifyController {


    @RequestMapping(value = ConstantUtil.LEFT_SLASH + ConstantUtil.PAY)
    public void payNotify(HttpServletRequest request, HttpServletResponse response) {

    }
}
