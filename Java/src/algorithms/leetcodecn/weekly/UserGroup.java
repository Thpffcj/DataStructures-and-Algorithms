package algorithms.leetcodecn.weekly;

/**
 * Created by thpffcj on 2019/12/8.
 */

import java.util.*;

/**
 * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位
 * 用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 *
 * 示例 1：
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 *
 * 解释：
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 *
 * 示例 2：
 * 输入：groupSizes = [2,1,3,3,3,2]
 * 输出：[[1],[0,5],[2,3,4]]
 *
 * 提示：
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 */
public class UserGroup {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> result = new ArrayList<>();
        if (groupSizes == null || groupSizes.length <= 0) {
            return result;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                map.get(groupSizes[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            }
        }

        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
        for (Map.Entry<Integer, List<Integer>> entry : list) {
            int key = entry.getKey();
            List<Integer> temp = entry.getValue();

            List<Integer> group = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                if (i % key == 0) {
                    group = new ArrayList<>();
                    result.add(group);
                }
                group.add(temp.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        UserGroup u = new UserGroup();
        u.groupThePeople(new int[]{3,3,3,3,3,1,3});
    }
}
