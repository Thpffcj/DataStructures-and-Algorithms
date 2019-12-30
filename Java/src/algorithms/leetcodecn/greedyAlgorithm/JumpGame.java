package algorithms.leetcodecn.greedyAlgorithm;

/**
 * Created by thpffcj on 2019/12/27.
 */

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class JumpGame {

    boolean flag;

    public boolean canJump(int[] nums) {

        flag = false;
        boolean[] visited = new boolean[nums.length];
        canJump(nums, 0, visited);
        return flag;
    }

    public void canJump(int[] nums, int position, boolean[] visited) {

        if (position >= nums.length || visited[position]) {
            return;
        }
        if (position == nums.length - 1) {
            flag = true;
            return;
        }

        visited[position] = true;
        int digit = nums[position];
        for (int i = digit; i > 0; i--) {
            canJump(nums, position + i, visited);
        }
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }
    Index[] memo;

    /**
     * 自顶向下的动态规划
     *
     * 自顶向下的动态规划可以理解成回溯法的一种优化。我们发现当一个坐标已经被确定为好 / 坏之后，结果就不会改变了，这意味着我们可以记录这
     * 个结果，每次不用重新计算。
     */
    public boolean canJump2(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    /**
     * 自底向上的动态规划
     *
     * 底向上和自顶向下动态规划的区别就是消除了回溯，在实际使用中，自底向下的方法有更好的时间效率因为我们不再需要栈空间，
     * 可以节省很多缓存开销。更重要的事，这可以让之后更有优化的空间。回溯通常是通过反转动态规划的步骤来实现的。
     */
    public boolean canJump3(int[] nums) {

        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }

    /**
     * 当我们把代码改成自底向上的模式，我们会有一个重要的发现，从某个位置出发，我们只需要找到第一个标记为 GOOD 的坐标（由跳出循环
     * 的条件可得），也就是说找到最左边的那个坐标。如果我们用一个单独的变量来记录最左边的 GOOD 位置，我们就可以避免搜索整个数组，
     * 进而可以省略整个 memo 数组。
     */
    public boolean canJump4(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {

        JumpGame j = new JumpGame();
        int[] nums = new int[]{2, 0};
        j.canJump(nums);
    }
}
