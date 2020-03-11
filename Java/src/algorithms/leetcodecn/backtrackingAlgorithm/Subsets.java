package algorithms.leetcodecn.backtrackingAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thpffcj on 2020/1/28.
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    Set<List<Integer>> set;
    public List<List<Integer>> subsets(int[] nums) {
        set = new HashSet<>();
        getSubsets(nums, new ArrayList<>(), 0);
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }

    public void getSubsets(int[] nums, List<Integer> list, int position) {
        if (position == nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }

        getSubsets(nums, list, position + 1);
        list.add(nums[position]);
        getSubsets(nums, list, position + 1);
        list.remove(list.size() - 1);
    }

    // 集合的每个元素，都有可以选或不选，用二进制和位运算，可以很好的表示
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // 1<<nums.length 等价于 2^nums.length,对于n个数字的数组，共2^n个子集
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                // 以0~(2^n)-1，2^n个n位二进制数，对应于所有子集，从后往前第 j 个二进制位为 0 表示不放入第 j 个元素,同理1表示放入。
                // " ((i >> j) & 1) == 1 " 表示对于二进制数i，从低位到高位逐个取其二进制位，并判断是否为1，若为1则放入对于nums
                // 中的元素
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }

        return res;
    }

    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
