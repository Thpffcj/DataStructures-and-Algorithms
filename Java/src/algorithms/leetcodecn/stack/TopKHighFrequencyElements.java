package algorithms.leetcodecn.stack;

/**
 * Created by thpffcj on 2019/11/14.
 */

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class TopKHighFrequencyElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        /**
         * TODO Java Map按值排序的常见思路是：
         * 将map中的entry放到List中
         * 对List中的entry通过比较器按值排序
         * 将排序后的entry放到map中
         */
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<Integer, Integer> entry : list) {
            result.add(entry.getKey());
        }
        return result.subList(0, k);
    }
}
