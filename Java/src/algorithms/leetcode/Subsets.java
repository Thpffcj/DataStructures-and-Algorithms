package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/5/30.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    /**
     * 我们可以一位一位的往上叠加，比如对于题目中给的例子[1,2,3]来说，最开始是空集，那么我们现在要处理1，就在空集上加1，
     * 为[1]，现在我们有两个自己[]和[1]，下面我们来处理2，我们在之前的子集基础上，每个都加个2，可以分别得到[2]，[1, 2]，
     * 那么现在所有的子集合为[], [1], [2], [1, 2]，同理处理3的情况可得[3], [1, 3], [2, 3], [1, 2, 3], 再加上之前的
     * 子集就是所有的子集合了
     * @param nums
     * @return
     */
//    public List<List<Integer>> subsets(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> first = new ArrayList<>();
//        result.add(first);
//        for (int i = 0; i < nums.length; i++) {
//            int n = result.size();
//            for (int j = 0; j < n; j++) {
//                List<Integer> list = result.get(j);
//                List<Integer> curr = new ArrayList<>(list);
//                curr.add(nums[i]);
//                result.add(curr);
//            }
//        }
//        return result;
//    }

    /**
     * 下面来看递归的解法，相当于一种深度优先搜索，由于原集合每一个数字只有两种状态，要么存在，要么不存在，那么在构造子集
     * 时就有选择和不选择两种情况，所以可以构造一棵二叉树，左子树表示选择该层处理的节点，右子树表示不选择，最终的叶节点就
     * 是所有子集合
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        subsets.subsets(nums);
    }
}
