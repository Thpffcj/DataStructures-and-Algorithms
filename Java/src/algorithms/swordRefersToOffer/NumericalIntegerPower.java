package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/8/28.
 */

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class NumericalIntegerPower {

    public double Power(double base, int exponent) {

        if (String.valueOf(base).equals("0.0") && exponent < 0) {
            return -1;
        }

        double result = 1.0;

        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        } else {
            exponent = (-exponent);
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            result = 1.0 / result;
        }

        return result;
    }
}
