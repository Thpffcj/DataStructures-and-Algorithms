package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/10.
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Offer20 {

    public boolean isNumeric(char[] str) {

        if (str == null || str.length <= 0) {
            return false;
        }

        boolean flag = false;
        int position = 0;
        if (str[0] == '+' || str[0] == '-') {
            position++;
        }

        if (getNumber(str, position) > position) {
            flag = true;
            position = getNumber(str, position);
        }

        if (position < str.length && str[position] == '.') {
            position++;

            if (getNumber(str, position) > position) {
                flag = true;
                position = getNumber(str, position);
            }
        }

        if (position < str.length && (str[position] == 'e' || str[position] == 'E')) {
            position++;

            if (position < str.length && (str[position] == '+' || str[position] == '-')) {
                position++;
            }

            if (!(flag && getNumber(str, position) > position)) {
                flag = false;
            }
            position = getNumber(str, position);
        }

        if (position < str.length) {
            flag = false;
        }

        return flag;
    }

    public int getNumber(char[] str, int position) {
        while (position < str.length
                && str[position] >= '0'
                && str[position] <= '9') {
            position++;
        }
        return position;
    }
}
