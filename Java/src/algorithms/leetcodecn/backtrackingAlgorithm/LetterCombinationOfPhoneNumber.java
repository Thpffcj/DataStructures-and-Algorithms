package algorithms.leetcodecn.backtrackingAlgorithm;

/**
 * Created by thpffcj on 2019/10/18.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinationOfPhoneNumber {

    public List<String> result = new ArrayList<>();

    public String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() <= 0) {
            return result;
        }

        letterCombinations("", digits, 0);
        return result;
    }

    public void letterCombinations(String s, String digits, int position) {
        if (s.length() == digits.length()) {
            result.add(s);
            return;
        }
        String letter = letters[Integer.parseInt(digits.charAt(position) + "")];
        for (int i = 0; i < letter.length(); i++) {
            s = s + letter.charAt(i);
            letterCombinations(s, digits, position + 1);
            s = s.substring(0, s.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber l = new LetterCombinationOfPhoneNumber();
        l.letterCombinations("23");
    }
}
