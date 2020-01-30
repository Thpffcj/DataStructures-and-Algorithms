package algorithms.swordRefersToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thpffcj on 2020/1/12.
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字
 * 符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Offer50_2 {

    public String stream = "";
    public Map<Character, Integer> map = new HashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        stream += ch;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < stream.length(); i++) {
            if (map.get(stream.charAt(i)) == 1) {
                return stream.charAt(i);
            }
        }

        return '#';
    }
}
