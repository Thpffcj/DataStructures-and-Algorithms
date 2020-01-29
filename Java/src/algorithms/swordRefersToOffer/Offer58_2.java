package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/28.
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Offer58_2 {

    public String LeftRotateString(String str,int n) {

        if (str == null || str.equals("")) {
            return "";
        }

        int length = str.length();
        if (n >= length) {
            n = n % length;
        }

        StringBuilder s = new StringBuilder(str);
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public static void main(String[] args) {
        Offer58_2 l = new Offer58_2();
        System.out.println(l.LeftRotateString("abcXYZdef", 100));
    }
}
