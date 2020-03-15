package algorithms.leetcodecn.depthFirstSearch;

import java.util.Stack;

/**
 * Created by thpffcj on 2019/12/13.
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class StringDecoding {

    /**
     * 本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应。
     *
     * 算法流程：
     * 构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
     * 当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
     * 当 c 为字母时，在 res 尾部添加 c；
     * 当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 00：
     *   记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
     *   记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
     *   进入到新 [ 后，res 和 multi 重新记录。
     * 当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
     *   last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
     *   cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
     *
     * 返回字符串 res。
     */
    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> stackMulti = new Stack<>();
        Stack<String> stackRes = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stackMulti.push(multi);
                stackRes.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = stackMulti.pop();
                String curRes = stackRes.pop();

                for (int i = 0; i < curMulti; i++) {
                    tmp.append(res);
                }

                res = new StringBuilder(curRes + tmp);
            }  else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }

    /**
     * 总体思路与辅助栈法一致，不同点在于将 [ 和 ] 分别作为递归的开启与终止条件：
     *
     * 当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
     * 当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 res + multi * tmp 拼接字符串。
     * 遍历完毕后返回 res。
     */
    public String decodeString2(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {

        StringBuilder res = new StringBuilder();
        int multi = 0;

        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            } else if(s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                // tmp[0] 是 ] 的位置
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if(s.charAt(i) == ']') {
                return new String[] { String.valueOf(i), res.toString() };
            } else {
                res.append(s.charAt(i));
            }
            i++;
        }
        return new String[] { res.toString() };
    }

    public static void main(String[] args) {
        StringDecoding s = new StringDecoding();
        System.out.println(s.decodeString2("3[a2[c]]"));
    }
}
