package algorithms.leetcodecn.bitOperation;

/**
 * Created by thpffcj on 2019/12/11.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常
 * 有帮助。
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 *
 * 示例：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 10){
            return result;
        }

        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            if (set.contains(s.substring(i, i + 10))) {
                set2.add(s.substring(i, i + 10));
            }
            set.add(s.substring(i, i + 10));
        }
        result.addAll(set2);

        return result;
    }
}
