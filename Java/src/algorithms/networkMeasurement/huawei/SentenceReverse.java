package algorithms.networkMeasurement.huawei;

/**
 * Created by Thpffcj on 2018/4/2.
 */

import java.util.Scanner;

/**
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * 输入描述:
 * 将一个英文语句以单词为单位逆序排放。
 *
 * 输出描述:
 * 得到逆序的句子
 *
 * 示例1
 * 输入
 * I am a boy
 * 输出
 * boy a am I
 */
public class SentenceReverse {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str = scan.nextLine();
        String res = reverse(str);
        System.out.println(res);
    }

    public static String reverse(String sentence) {
        String[] s = sentence.split(" ");
        int n = s.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[n - 1 - i] = s[i];
        }
        String re = "";
        for (int i = 0; i < n - 1; i++) {
            re = re + res[i] + " ";
        }
        re = re + res[n - 1];
        return re;
    }
}
