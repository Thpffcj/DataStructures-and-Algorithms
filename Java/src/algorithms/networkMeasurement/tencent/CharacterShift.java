package algorithms.networkMeasurement.tencent;

import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/26.
 *
 * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 * 你能帮帮小Q吗？
 *
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 *
 * 输出描述:
 * 对于每组数据，输出移位后的字符串。
 *
 * 输入例子1:
 * AkleBiCeilD
 *
 * 输出例子1:
 * kleieilABCD
 */
public class CharacterShift {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] characters = sc.nextLine().toCharArray();
            for (int i = characters.length - 1; i >= 0; i--) {
                Character current = characters[i];
                if (current >= 'A' && current <= 'Z') {
                    for (int j = i; j < characters.length - 1; j++) {
                        if (characters[j + 1] >= 'a' && characters[j + 1] <= 'z') {
                            Character c = characters[j];
                            characters[j] = characters[j + 1];
                            characters[j + 1] = c;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < characters.length; i++) {
                sb.append(characters[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
