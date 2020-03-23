package algorithms.leetcodecn.backtrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thpffcj on 2019/12/17.
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 *
 * 注意：
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class LetterCasePermutation {

    /**
     * 如果下一个字符 c 是字母，将当前已遍历过的字符串全排列复制两份，在第一份的每个字符串末尾添加 lowercase(c)，在第二份的
     * 每个字符串末尾添加 uppercase(c)。
     * 如果下一个字符 c 是数字，将 c 直接添加到每个字符串的末尾。
     */
    public List<String> letterCasePermutation(String S) {

        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (char c : S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i) {
                    ans.get(i).append(c);
                }
            }
        }

        List<String> result = new ArrayList();
        for (StringBuilder sb: ans) {
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCasePermutation a = new LetterCasePermutation();
        a.letterCasePermutation("a1b2");
    }
}
