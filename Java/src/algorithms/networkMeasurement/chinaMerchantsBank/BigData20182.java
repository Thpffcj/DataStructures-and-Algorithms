package algorithms.networkMeasurement.chinaMerchantsBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/5.
 *
 * 科室素拓进行游戏，游戏规则如下：随机抽取9个人作为游戏参与人员，分别编号1至9，每轮要求k(k<=9且k>=0)个人自由组合使编号之和为
 * n。输出满足规则的所有可能的组合。要求组合内部编号升序输出，组合之间无顺序要求。
 *
 * 输入描述:
 * 输入数据为以空格分隔的两个整数k和n
 *
 * 输出描述:
 * 每行输出一个可能的编号组合，组合内部各个编号以空格分隔升序输出。若无满足规则的组合，则输出None
 *
 * 输入例子1:
 * 3 15
 *
 * 输出例子1:
 * 1 5 9
 * 1 6 8
 * 2 4 9
 * 2 5 8
 * 2 6 7
 * 3 4 8
 * 3 5 7
 * 4 5 6
 */
public class BigData20182 {

    static List<String> list;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        list = new ArrayList<>();
        arrange("", 0, 1, k, n);
        if (list.size() == 0) {
            System.out.println("None");
        } else {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public static void arrange(String s, int sum, int digit, int k, int n) {

        if (sum == n && s.length() == 2 * k) {
            list.add(s.substring(0, s.length() - 1));
            return;
        }

        for (int i = digit; i <= 9; i++) {
            if (sum + i > n || s.length() >= 2 * k) {
                break;
            }
            String temp = s + i + " ";
            arrange(temp, sum + i, i + 1, k, n);
        }
    }
}
