package algorithms.advancedAlgorithm.homework.homework2;

import java.util.*;

/**
 * Created by thpffcj on 2019/10/26.
 */

/**
 * 计数排序
 * Description
 * 实现计数排序，通过多次遍历数组，统计比每一个元素小的其它元素个数，根据该统计量对数据进行排序。
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 *
 * Sample Input 1
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 *
 * Sample Output 1
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */
public class CountSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            int[] digits = new int[number];
            for (int i = 0; i < number; i++) {
                digits[i] = sc.nextInt();
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < digits.length; i++) {
                map.put(i, 0);
            }

            for (int i = 0; i < digits.length; i++) {
                int digit = digits[i];
                for (int j = 0; j < digits.length; j++) {
                    if (digit < digits[j]) {
                        map.put(j, map.get(j) + 1);
                    }
                }
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, Integer> mapping : list){
                sb.append(digits[mapping.getKey()]).append(" ");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
