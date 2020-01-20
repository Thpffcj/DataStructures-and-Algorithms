package algorithms.networkMeasurement.byteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/19.
 *
 * 字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。询问在至多交换m次之后，字符串中最多有
 * 多少个连续的位置上的字母相同？
 *
 * 输入描述:
 * 第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)
 *
 * 输出描述:
 * 一个非负整数，表示操作之后，连续最长的相同字母数量。
 *
 * 输入例子1:
 * abcbaa 2
 *
 * 输出例子1:
 * 2
 *
 * 例子说明1:
 * 使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
 * 所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现。
 */
public class BigData20186 {

    /**
     * 两个要点
     *
     * 对所有字母遍历，每次只考虑当前字母，也就是记录当前字母的位置。
     * 动态递归。对每一种可能的长度（从2开始，因为结果必定大于等于1），递推关系式为：
     * dp[i][i + len - 1] = dp[i + 1][i + len - 2] + pos.get(i + len - 1) - pos.get(i) + 1 - len
     * 意思是，pos[i]->pos[i + len - 1]之间的最小移动次数等于pos[i + 1]->pos[i + len - 2]的最小移动次数加上
     * pos.get(i + len - 1) - pos.get(i) + 1 - len。也就是掐头去尾，都往中间移动，然后把两边的靠过来的步数。
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int m = sc.nextInt();

        int res = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            List<Integer> pos = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if (c == str.charAt(i)) {
                    pos.add(i);
                }
            }
            if (pos.size() < 2) {
                continue;
            }
            int ans = 1;
            int[][] dp = new int[pos.size()][pos.size()];
            for (int len = 2; len <= pos.size(); len++) {
                for (int i = 0; i + len - 1 < pos.size(); i++) {
                    dp[i][i + len - 1] = dp[i + 1][i + len - 2] + pos.get(i + len - 1) - pos.get(i) + 1 - len;
                    if (dp[i][i + len - 1] <= m) {
                        ans = len;
                    }
                }
            }
            res = res > ans ? res : ans;
        }
        System.out.println(res);
    }
}
