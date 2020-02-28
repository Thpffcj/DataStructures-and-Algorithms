package algorithms.leetcodecn.z_hot;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/2/27.
 */
public class ThirtySixHex {

    static Character[] nums = {'0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static List<Character> list = Arrays.asList(nums);

    // 按照十进制的加法方法，满36向前进一位
    static String add(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i = s1.length - 1;
        int j = s2.length - 1;
        // 进位
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            char c1 = s1[i];
            char c2 = s2[j];
            int index1 = list.indexOf(c1);
            int index2 = list.indexOf(c2);
            int sum = index1 + index2 + carry;
            if (sum >= 36) {
                carry = 1;
                sb.append(list.get(sum % 36));
            } else {
                carry = 0;
                sb.append(list.get(sum));
            }
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = list.indexOf(s1[i]) + carry;
            if (sum >=36) {
                carry = 1;
                sb.append(list.get(sum % 36));
            } else {
                carry=0;
                sb.append(list.get(sum));
            }
            i--;
        }
        while (j >= 0) {
            int sum = list.indexOf(s2[j]) + carry;
            if (sum >=36) {
                carry = 1;
                sb.append(list.get(sum % 36));
            } else {
                carry=0;
                sb.append(list.get(sum));
            }
            j--;
        }
        if(carry != 0){
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        String result = add(str1, str2);
        System.out.println(result);
    }
}
