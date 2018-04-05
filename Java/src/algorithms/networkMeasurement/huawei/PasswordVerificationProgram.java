package algorithms.networkMeasurement.huawei;

/**
 * Created by Thpffcj on 2018/4/2.
 */

import java.util.Scanner;

/**
 * 题目描述
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 *
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * OK
 * NG
 * NG
 * OK
 */
public class PasswordVerificationProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String password = sc.nextLine();
            if (checkLength(password) && checkCharKinds(password) && checkCharRepeat(password)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    // 1.长度超过8位
    private static boolean checkLength(String password){
        if (password.length() <= 8) {
            return false;
        }
        return true;
    }

    // 2.包括大小写字母.数字.其它符号,以上四种至少三种
    private static boolean checkCharKinds(String password){
        int big = 0;
        int small = 0;
        int digit = 0;
        int other = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= '0' && c <= '9') {
                digit = 1;
            } else if (c >= 'A' && c <= 'Z') {
                big = 1;
            } else if (c >= 'a' && c <= 'z') {
                small = 1;
            } else {
                other = 1;
            }
        }
        if ((big + small + digit + other) >= 3) {
            return true;
        }
        return false;
    }

    // 3.不能有相同长度超2的子串重复
    private static boolean checkCharRepeat(String password){
        for (int i = 0; i < password.length() - 2; i++) {
            String s1 = password.substring(i, i + 3);
            if (password.substring(i + 1).contains(s1)) {
                return false;
            }
        }
        return true;
    }
}