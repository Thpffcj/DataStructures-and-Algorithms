package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/30.
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Offer65 {

    public int Add(int num1, int num2) {

        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
