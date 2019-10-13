package algorithms.leetcodecn.hashTable;

/**
 * Created by thpffcj on 2019/10/12.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道
 * 你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 注意:
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 */
public class GemsAndStones {

    public int numJewelsInStones(String J, String S) {

        if (J == null || S == null || J.equals("") || S.equals("")) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}
