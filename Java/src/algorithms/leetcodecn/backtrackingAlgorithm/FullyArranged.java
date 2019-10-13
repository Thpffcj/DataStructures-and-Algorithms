package algorithms.leetcodecn.backtrackingAlgorithm;

/**
 * Created by thpffcj on 2019/10/12.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class FullyArranged {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        findArrange(list, nums, visited);
        return result;
    }

    public void findArrange(List<Integer> list, int[] nums, boolean[] visited) {

        if (list.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                list.add(nums[i]);
                visited[i] = true;
                findArrange(list, nums, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
