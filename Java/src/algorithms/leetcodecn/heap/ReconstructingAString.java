package algorithms.leetcodecn.heap;

import java.util.*;

/**
 * Created by thpffcj on 2019/12/11.
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 *
 * 注意:
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class ReconstructingAString {

    public String reorganizeString(String S) {

        if (S == null || S.length() <= 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            } else {
                map.put(S.charAt(i), 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        Character[] c = new Character[S.length()];
        Arrays.fill(c, '0');
        int position = 0;
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                while (c[position] != '0') {
                    position++;
                    if (position >= c.length) {
                        position = 0;
                    }
                }
                c[position] = entry.getKey();
                position += 2;
                if (position >= c.length) {
                    position = 0;
                }
            }
        }

        String result = "" + c[0];
        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i - 1]) {
                return "";
            } else {
                result += c[i];
            }
        }

        return result;
    }

    /**
     * 当某个字符的出现次数大于字符总数的一半时，必然无法进行重构，返回空字符串。先将字符串中的每个字符按照26个字母的排序进行放置形成
     * 数组，出现次数作为数组的元素。
     * 遍历数组，将字符串中的字符按照奇数偶数放在新建的char数组中。将相同的字符个数小于字符串长度的一半的字符放在奇数下标位置，否则放
     * 在偶数下标位置。
     * 注意这里需要判断奇数位置是否大于字符串长度。
     */
    public String reorganizeString2(String S) {

        int length = S.length();
        if (length == 1) {
            return S;
        }

        int[] arr = new int[26];
        int maxLength = 0;
        for (char c : S.toCharArray()) {
            arr[c - 'a']++;
            if (maxLength < arr[c - 'a']) {
                maxLength = arr[c - 'a'];
            }
        }
        if (maxLength > (length + 1) / 2) {
            return "";
        }

        char[] result = new char[S.length()];
        int even = 0;
        int odd = 1;
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0 && arr[i] < (length / 2 + 1) && odd < length) {
                result[odd] = (char) (i + 'a');
                arr[i]--;
                odd += 2;
            }
            while (arr[i] > 0) {
                result[even] = (char) (i + 'a');
                arr[i]--;
                even += 2;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        ReconstructingAString r = new ReconstructingAString();
        System.out.println(r.reorganizeString2("abc"));
    }
}
