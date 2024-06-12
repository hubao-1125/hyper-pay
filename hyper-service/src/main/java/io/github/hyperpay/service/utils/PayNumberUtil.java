package io.github.hyperpay.service.utils;

import cn.hutool.core.date.DateUtil;
import io.github.hyperpay.service.core.LettuceRedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

/**
 * 功能描述: 支付订单号工具-类
 *
 * @author hubao
 * @since 2024/6/11 17:23
 */
@Component
public class PayNumberUtil {

    @Autowired
    private LettuceRedisClient lettuceRedisClient;

    private static final String TIME_PATTERN_YY_MM_DD = "yyMMdd";
    private static final String TIME_PATTERN_YY_MM_DD_HH_MM_SS = "yyMMddHHmmss";
    
    @Value("${pay.env}")
    private String env;

    private static final Integer TWO_DAY_SECONDS = 172800;

    private static final String PAY_NUMBER_REDIS_PREFIX = "PAY_NUMBER:";

    private String generatePayNumber(String timePatten, int numberLength) {

        String formatTime = DateUtil.format(new Date(), timePatten);
        int firstLength = 1 + timePatten.length();

        StringBuffer buffer = new StringBuffer();
        buffer.append(env);
        buffer.append(formatTime);

        String key = PAY_NUMBER_REDIS_PREFIX + numberLength + ":" + formatTime;
        Long incr = lettuceRedisClient.incrExpire(key, TWO_DAY_SECONDS);

        Integer incredLength = incr.toString().length();
        buffer.append(incredLength);
        buffer.append(incr.toString());
        incredLength = incredLength + String.valueOf(incredLength).length();
        Random random = new Random();
        for (int i = 0; i < numberLength - incredLength - firstLength; ++i) {
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();
    }

    public String generatePayNumber16() {
        return generatePayNumber(TIME_PATTERN_YY_MM_DD, 16);
    }
    public String generatePayNumber24() {
        return generatePayNumber(TIME_PATTERN_YY_MM_DD_HH_MM_SS, 24);
    }

    public String generatePayNumber32() {
        return generatePayNumber(TIME_PATTERN_YY_MM_DD_HH_MM_SS, 32);
    }

}
