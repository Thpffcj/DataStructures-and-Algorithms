package algorithms.networkMeasurement.baidu;

/**
 * Created by Thpffcj on 2018/3/21.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 度度熊收到了一个只有小写字母的字符串S，他对S的子串产生了兴趣，S的子串为S中任意连续的一段。他发现，一些子串只由一种字母构成，
 * 他想知道在S中一共有多少种这样的子串。
 * 例如在串”aaabbaa”中，度度熊想找的子串有”a”,”aa”,”aaa”,”b”,”bb”五种。
 * （本题只考虑子串的种数，相同的子串在多个位置出现只算一次）
 */
public class TheDegreeBearLooksForAString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            Set<String> res = new HashSet<>();
            String s = "";
            int j = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != line.charAt(j)) {
                    j = i;
                    s = "";
                }
                s = s + line.charAt(i);
                res.add(s);
            }
            System.out.println(res.size());
        }
    }
}
