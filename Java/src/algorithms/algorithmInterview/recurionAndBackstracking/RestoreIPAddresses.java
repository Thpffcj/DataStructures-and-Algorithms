package algorithms.algorithmInterview.recurionAndBackstracking;

/**
 * Created by Thpffcj on 2018/3/14.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP
 * address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {

    /**
     * 只要遇到字符串的子序列或配准问题首先考虑动态规划DP
     * 只要遇到需要求出所有可能情况首先考虑用递归。
     *
     * 这道题并非是求字符串的子序列或配准问题，更符合第二种情况，所以我们要用递归来解。
     * 我们用k来表示当前还需要分的段数，如果k = 0，则表示三个点已经加入完成，四段已经形成，
     * 若这时字符串刚好为空，则将当前分好的结果保存。
     * 若k != 0, 则对于每一段，我们分别用一位，两位，三位来尝试，分别判断其合不合法，
     * 如果合法，则调用递归继续分剩下的字符串，最终和求出所有合法组合
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, 0, "", res);
        return res;
    }

    public void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) res.add(out);
            return;
        }
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            int val = Integer.parseInt(s.substring(0, k));
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }
    }
}
