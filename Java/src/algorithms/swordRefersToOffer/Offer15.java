package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/8/24.
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Offer15 {

    int  NumberOf1(int n) {

        int result = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                result++;
            }
            flag = flag << 1;
        }

        return result;
    }
}
