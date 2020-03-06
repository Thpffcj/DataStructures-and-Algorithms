package algorithms.networkMeasurement.chinaMerchantsBank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/5.
 *
 * 现在信用卡开展营销活动，持有我行信用卡客户推荐新户办卡，开卡成功后可获得积分奖励。规定每个客户最多可推荐两个新户且一个新户只
 * 能被推荐一次。但允许链接效应，即若客户A推荐了新户B，新户B推荐新户C，则客户C同时属于A和B的推荐列表。简单起见，只考虑以一个老
 * 客户A作起点推荐的情况。编程计算推荐新户数不小于n的客户列表。
 *
 * 输入描述:
 * 输入的第一行为以空格分隔的两个正整数，第一个表示原始推荐列表的个数m，第二个表示n的取值。
 * 其后m行每行均为一个以空格分隔的原始推荐列表，第一列为推荐人，后面两列为被推荐人，若该推荐人只推荐了一个新户，则第三列以*替代。
 * 推荐人和被推荐人均以大写字母表示，不同字母代表不同的人。
 *
 * 输出描述:
 * 在同一行输出符合条件的客户列表，无顺序要求，客户间以空格分隔。若客户列表为空，则输出None。详见样例。
 *
 * 输入例子1:
 * 5 2
 * A B C
 * C F *
 * B D E
 * D G *
 * E H I
 *
 * 输出例子1:
 * A B E
 */
public class BigData20181 {

    /**
     * 答案错误:您提交的程序没有通过所有的测试用例
     * case通过率为83.33%
     * 思路应该是DFS
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int m = Integer.parseInt(line.split(" ")[0]);
        int n = Integer.parseInt(line.split(" ")[1]);
        Map<String, String> map = new HashMap<>();
        Map<String, Long> result = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] s = sc.nextLine().split(" ");
            String person1 = s[0];
            String person2 = s[1];
            String person3 = s[2];
            String person4 = map.get(person1);

            map.put(person2, person1);
            if (result.containsKey(person1)) {
                result.put(person1, result.get(person1) + result.getOrDefault(person2, 0L) + 1);
            } else {
                result.put(person1, result.getOrDefault(person2, 0L) + 1);
            }
            if (person4 != null) {
                result.put(person4, result.getOrDefault(person2, 0L) + result.get(person4) + 1);
            }
            if (!person3.equals("*")) {
                map.put(person3, person1);
                result.put(person1, result.get(person1) + result.getOrDefault(person3, 0L) + 1);
                if (person4 != null) {
                    result.put(person4, result.getOrDefault(person3, 0L) + result.get(person4) + 1);
                }
            }
        }

        String s = "";
        for (Map.Entry<String, Long> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
//            if (entry.getValue() >= n) {
                s += entry.getKey() + " ";
//            }
        }
        if (s.equals("")) {
            System.out.println("None");
        } else {
            System.out.println(s.substring(0, s.length() - 1));
        }
    }
}
//5 5
//C F *
//B D E
//D G *
//E H I
//A B C