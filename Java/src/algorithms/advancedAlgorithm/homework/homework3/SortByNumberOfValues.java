package algorithms.advancedAlgorithm.homework.homework3;

/**
 * Created by thpffcj on 2019/11/18.
 */

import java.util.*;

/**
 * Description
 * 对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，如果出现次数相同，则按照数值大小排序。例如，给定数组为
 * {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}，则排序后结果为{3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}。
 *
 * Input
 * 输入的第一行为用例个数；后面每一个用例使用两行表示，第一行为数组长度，第二行为数组内容，数组元素间使用空格隔开。
 *
 * Output
 * 每一个用例的排序结果在一行中输出，元素之间使用空格隔开。
 *
 * Sample Input 1
 * 1
 * 4
 * 2 3 2 5
 *
 * Sample Output 1
 * 2 2 3 5
 */
public class SortByNumberOfValues {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();

        while (numbers > 0) {
            int n = sc.nextInt();
            int[] digit = new int[n];
            for (int i = 0; i < n; i++) {
                digit[i] = sc.nextInt();
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < digit.length; i++) {
                if (map.containsKey(digit[i])) {
                    map.put(digit[i], map.get(digit[i]) + 1);
                } else {
                    map.put(digit[i], 1);
                }
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if (o1.getValue() != o2.getValue()) {
                        return o2.getValue().compareTo(o1.getValue());
                    } else {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            });

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : list) {
                int number = entry.getValue();
                while (number > 0) {
                    sb.append(entry.getKey()).append(" ");
                    number--;
                }
            }

            System.out.println(sb.substring(0, sb.length() - 1));

            numbers--;
        }
    }
}
