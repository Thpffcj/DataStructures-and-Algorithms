package algorithms.networkMeasurement.huawei;

/**
 * Created by Thpffcj on 2018/4/3.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 查找和排序
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩都按先录入排列在前的规则处理。
 *
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 * smith     67
 * Tom       70
 * jack      70
 * peter     96
 *
 * 输入描述:
 * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
 *
 * 输出描述:
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 *
 * 输入
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 * 输出
 * fang 90
 * ning 70
 * yang 50
 */
public class SortByResults {

    // TODO
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            int type = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                map.put(input[0], Integer.parseInt(input[1]));
            }

        }
    }
}