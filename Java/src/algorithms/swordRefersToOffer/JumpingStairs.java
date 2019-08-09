package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019-08-09.
 */

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpingStairs {

    public int JumpFloor(int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}
