package algorithms.leetcodecn.backtrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thpffcj on 2020/2/12.
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIpAddresses {

    List<String> result;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        restore(s, "", 0, 0);
        return result;
    }

    public void restore(String s, String cur, int number, int position) {

        if (number == 4 && position == s.length()) {
            result.add(cur.substring(0, cur.length() - 1));
            return;
        }

        if (number > 4 || position >= s.length()) {
            return;
        }

        String ip = "";
        for (int i = position; i < Math.min(s.length(), position + 3); i++) {
            ip += s.charAt(i);
            if (isValid(ip)) {
                String temp = cur + ip + ".";
                restore(s, temp, number + 1, i + 1);
            }
        }
    }

    public boolean isValid(String s) {
        int ip = Integer.parseInt(s);
        if (s.charAt(0) == '0') {
            return s.length() == 1 && ip == 0;
        } else {
            return ip > 0 && Integer.parseInt(s) <= 255;
        }
    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> ret = new ArrayList<>();
        StringBuilder ip = new StringBuilder();
        for(int a = 1 ; a < 4 ; ++ a) {
            for(int b = 1 ; b < 4 ; ++ b) {
                for(int c = 1 ; c < 4 ; ++ c) {
                    for(int d = 1 ; d < 4 ; ++ d) {
                        if(a + b + c + d == s.length()) {
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a+b));
                            int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
                            int n4 = Integer.parseInt(s.substring(a+b+c));
                            if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                ip.append(n1).append('.').append(n2)
                                        .append('.').append(n3).append('.').append(n4);
                                if(ip.length() == s.length() + 3) {
                                    ret.add(ip.toString());
                                }
                                ip.delete(0, ip.length());
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    public List<String> restoreIpAddresses3(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs(s, 0, res, 0, "");
        return res;
    }

    /**
     * String s: 原始字符串
     * int start: 每一层截取字符串的起始索引
     * List<String> res: 返回结果集
     * int count: 层数,也是ip地址段的段数(1,2,3,4)
     * String ip: 复原的ip地址
     */
    public void dfs(String s, int start, List<String> res, int count, String ip){
        // 只需要递归到第4层.
        if(count > 4) {
            return;
        }
        // 这里进行结算, ip段4个segment遍历完成且s的所有字符都被分配完毕.
        if(count == 4 && start == s.length()) {
            res.add(ip);
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(start + i > s.length()) {
                break;
            }

            int data = Integer.parseInt(s.substring(start, start + i));
            if((i > 1 && (s.charAt(start) - '0') == 0) || data > 255) {
                break;
            }
            dfs(s, start + i, res, count + 1, ip + data + (count == 3 ? "" : "."));
        }
    }
}
