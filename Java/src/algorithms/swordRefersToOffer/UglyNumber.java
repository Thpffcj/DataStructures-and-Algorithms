package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/10/1.
 */

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {

    public int GetUglyNumber_Solution(int index) {

        if (index <= 0) {
            return 0;
        }

        int ugly[] = new int[index];
        ugly[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int uglyIndex = 1; uglyIndex < index; uglyIndex++) {
            int minNumber = min(ugly[multiply2] * 2, ugly[multiply3] * 3, ugly[multiply5] * 5);
            ugly[uglyIndex] = minNumber;

            while (ugly[multiply2] * 2 <= ugly[uglyIndex]) {
                multiply2++;
            }
            while (ugly[multiply3] * 3 <= ugly[uglyIndex]) {
                multiply3++;
            }
            while (ugly[multiply5] * 5 <= ugly[uglyIndex]) {
                multiply5++;
            }
        }

        return ugly[index - 1];
    }

    public int min(int a, int b, int c) {
        int result = a;
        if (b < a) {
            result = b;
        }
        if (c < result) {
            result = c;
        }
        return result;
    }
}
