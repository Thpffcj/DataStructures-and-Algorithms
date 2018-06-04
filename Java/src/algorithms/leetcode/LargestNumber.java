package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/6/4.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 *
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    /**
     * 这道题给了我们一个数组，让我们将其拼接成最大的数，那么根据题目中给的例子来看，主要就是要给给定数组进行排序，但是排序方
     * 法不是普通的升序或者降序，因为9要排在最前面，而9既不是数组中最大的也不是最小的，所以我们要自定义排序方法。这种解法对于
     * 两个数字a和b来说，如果将其都转为字符串，如果ab > ba，则a排在前面，比如9和34，由于934>349，所以9排在前面，再比如说30
     * 和3，由于303<330，所以3排在30的前面。按照这种规则对原数组进行排序后，将每个数字转化为字符串再连接起来就是最终结果
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(s, comp);

        if (s[0].equals("0")) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        for (String digit : s) {
            sb.append(digit);
        }

        return sb.toString();
    }
}
