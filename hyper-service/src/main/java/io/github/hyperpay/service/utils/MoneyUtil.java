package io.github.hyperpay.service.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 *
 * @author hubao
 * @since 2024/6/18 10:28
 */
public class MoneyUtil {

    public static final BigDecimal ZERO = new BigDecimal("0.00");
    public static final BigDecimal ONE_HUNDRED_INT = new BigDecimal(100);
    public static final BigDecimal ONE = new BigDecimal("1");
    public static final BigDecimal ZERO_POINT_ZERO_ONE = new BigDecimal("0.01");
    public static final BigDecimal ZERO_POINT_ONE = new BigDecimal("0.1");

    public static BigDecimal castLongToYuan(Long amount)
    {
        if (Objects.isNull(amount)) {
            return ZERO;
        }
        if (amount <= 0) {
            return BigDecimal.ZERO;
        }

        return new BigDecimal(String.valueOf(amount))
                .divide(ONE_HUNDRED_INT).setScale(2, RoundingMode.HALF_DOWN);
    }

    public static Long castBigDecimalToPoint(BigDecimal amount)
    {
        if (Objects.isNull(amount)) {
            return 0L;
        }
        // 如果订单金额为0
        if (amount.compareTo(new BigDecimal("0.00")) == 0) {
            return 0L;
        }
        return Long.valueOf(String.valueOf(amount.multiply(ONE_HUNDRED_INT).setScale(0, RoundingMode.DOWN)));
    }
}
