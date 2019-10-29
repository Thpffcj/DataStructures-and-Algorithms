package algorithms.advancedAlgorithm.homework.homework2;

import java.util.*;

/**
 * Created by thpffcj on 2019/10/26.
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
