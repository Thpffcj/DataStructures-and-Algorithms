package algorithms.leetcodecn.weekly.oneHundredSixtySeven;

/**
 * Created by thpffcj on 2019/12/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 *
 * 示例 1：
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 *
 * 示例 2：
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 *
 * 提示：
 * 10 <= low <= high <= 10^9
 */
public class InOrderNumber {

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();
        int length = String.valueOf(low).length();

        int digit = getStart(length);
        while (digit <= high) {

            if (digit >= low) {
                result.add(digit);
            }

            digit += getAdd(length);
            if (digit % 10 == 0) {
                length++;
                digit = getStart(length);
            }
        }

        return result;
    }

    public int getStart(int length) {
        int start = 0;
        for (int i = 1; i <= length; i++) {
            start = start * 10 + i;
        }
        return start;
    }

    public int getAdd(int length) {
        String result = "";
        while (length > 0) {
            result += "1";
            length--;
        }
        return Integer.parseInt(result);
    }
}
