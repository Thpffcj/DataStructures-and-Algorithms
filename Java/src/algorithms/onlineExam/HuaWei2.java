package algorithms.onlineExam;

import java.util.Scanner;

/**
 * Created by Thpffcj on 2018/4/3.
 */

/**
 * 题目描述
 * IPv6地址为128位，完整的文本格式写成8段16位的形式，例如：
 * 2001:1002:FFFF:ABCD:1234:1234:0000:0001
 *
 * 简写时，会将其中全0的字段压缩，例如：
 *
 * 2001:0000:0000:0000:0000:0000:0000:0001会简写成2001::0001
 *
 * 0000:0000:0000:0000:0000:0000:0000:0001会简写成::0001或者::1
 *
 * IPv6地址包括以下类型：
 *
 * 地址类型
 *
 * 地址前缀（二进制）
 *
 * IPv6前缀标识
 *
 * 单播地址
 *
 * 未指定地址
 *
 * 00…0(128 bits)
 *
 * ::/128
 *
 * 环回地址
 *
 * 00…1(128 bits)
 *
 * ::1/128
 *
 * 链路本地地址
 *
 * 1111111010
 *
 * FE80::/10
 *
 * 站点本地地址
 *
 * 1111111011
 *
 * FEC0::/10
 *
 * 全球单播地址
 *
 * 其他形式
 *
 * -
 *
 * 组播地址
 *
 * 11111111
 *
 * FF00::/8
 *
 * 任播地址
 *
 * 从单播地址空间中进行分配，使用单播地址的格式
 *
 * 备注：地址标识中一般以”/”后带的数字来表示掩码，例如上面的”FF00::/8“表示的是前8比特为1，后面120比特为任意值
 * 请实现一段代码，来判断输入的IPv6地址字符串的类型。
 *
 * 输入描述:
 * 一行字符串，完整形式的IPv6地址
 * 输出描述:
 * 输出一个字符串，表示是何种类型的IPv6地址，输出可以是：
 * Unspecified    未指定地址
 * Loopback       环回地址
 * LinkLocal       链路本地地址
 * SiteLocal        站点本地地址
 * GlobalUnicast     全球单播地址
 * Multicast        组播地址
 * Error              错误的地址，或者非完整形式IPv6地址的字符串
 * 示例1
 * 输入
 * FE81:0001:0000:0000:FF01:0203:0405:0607
 * 输出
 * LinkLocal
 */
public class HuaWei2 {

    public static String[] digit = {"0000", "0001", "0010", "0011",
    "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011",
    "1100", "1101", "1110", "1111"};

    public static String a = "0123456789ABCDEF";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(":");
            String res = type(line);
            System.out.println(res);
        }
    }

    public static String type(String[] s) {
        if (s.length != 8) {
            return "Error";
        }
        String d1 = digit[a.indexOf(s[0].charAt(0))];
        if (d1.equals("1111")) {
            String d2 = digit[a.indexOf(s[0].charAt(1))];
            if (d2.equals("1111")) {
                return "Multicast";
            } else if (d2.equals("1110")) {
                String d3 = digit[a.indexOf(s[0].charAt(2))];
                if (d3.charAt(0) == '1' && d3.charAt(1) == '0') {
                    return "LinkLocal";
                } else if (d3.charAt(0) == '1' && d3.charAt(1) == '1') {
                    return "SiteLocal";
                }
            }
        } else {
            String d2 = digit[a.indexOf(s[7].charAt(0))];
            String d3 = digit[a.indexOf(s[7].charAt(1))];
            String d4 = digit[a.indexOf(s[7].charAt(2))];
            if (d2.equals("0000") && d3.equals("0000") && d4.equals("0000")) {
                String d5 = digit[a.indexOf(s[7].charAt(3))];
                if (d5.equals("0000")) {
                    return "Unspecified";
                } else if (d5.equals("0001")) {
                    return "Loopback";
                }
            }
        }
        return "GlobalUnicast";
    }
}
