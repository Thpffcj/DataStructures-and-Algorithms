package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/27.
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1
 * （需要区分大小写）.
 */
public class Offer50 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.equals("")) {
            return -1;
        }

        int[] bucket = new int[200];
        int[] order = new int[200];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (order[c] == 0) {
                order[c] = i;
            }
            bucket[c]++;
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 1) {
                if (order[i] < position) {
                    position = order[i];
                }
            }
        }
        if (position == Integer.MAX_VALUE) {
            return -1;
        }

        return position;
    }

    public static void main(String[] args) {
        Offer50 t = new Offer50();
        System.out.println(t.FirstNotRepeatingChar("google"));
    }
}
