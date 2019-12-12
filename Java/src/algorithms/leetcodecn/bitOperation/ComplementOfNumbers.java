package algorithms.leetcodecn.bitOperation;

/**
 * Created by thpffcj on 2019/12/11.
 */

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 注意:
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 *
 * 示例 1:
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 *
 * 示例 2:
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 */
public class ComplementOfNumbers {

    public int findComplement(int num) {

        String s = "";
        while (num > 0) {
            int n = num % 2;
            s = n + s;
            num = num / 2;
        }

        int result= 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result += Math.pow(2, s.length() - 1 - i);
            }
        }

        return result;
    }

    // 101（5) * 111 = 010
    // 我们只要拿到一个位数和num一样切所有位都为1的数就好了
    public int findComplement2(int num) {

        int tmp = num;
        int num2 = 1;

        while(tmp > 0){
            num2 = num2 << 1;
            tmp = tmp >> 1;
        }
        num2 -= 1;
        return num ^ num2;
    }
}
