package io.github.hyperpay.service.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 功能描述: -类
 *
 * @author hubao
 * @since 2024/6/11 17:42
 */
@Slf4j
public class PayNumberUtilTest {

    @Autowired
    private PayNumberUtil payNumberUtil;

    @Test
    public void generatePayNumber16Test() {

        log.info(payNumberUtil.generatePayNumber16());
    }
}
