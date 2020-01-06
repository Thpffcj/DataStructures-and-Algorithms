package algorithms.leetcodecn.weekly.oneHundredAndSeventy;

/**
 * Created by thpffcj on 2020/1/5.
 *
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。对于每个查询 i，计算从 Li 到 Ri 的 XOR
 * 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）。返回一个包含给定查询 queries 结果的数组。
 *
 * 示例 1：
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 *
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 *
 * 示例 2：
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 *
 * 提示：
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 */
public class XorQueriesOfASubarray {

    // 提交结果：超出内存限制
    public int[] xorQueries(int[] arr, int[][] queries) {

        int[][] xor = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            xor[i][i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                xor[i][j] = xor[i][j - 1] ^ arr[j];
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = xor[queries[i][0]][queries[i][1]];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 3);
    }
}
