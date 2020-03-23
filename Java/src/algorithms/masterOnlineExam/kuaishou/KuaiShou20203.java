package algorithms.masterOnlineExam.kuaishou;

import java.util.*;

/**
 * Created by thpffcj on 2020/3/22.
 *
 * 15112347234,15176313245,15176313346,15176313325,15166667234,15188847234
 */
public class KuaiShou20203 {

    private static Set<String> set1;
    private static Set<String> set2;
    private static  Set<String> set3;
    private static Set<String> set4;

    // 90.91%
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set3 = new HashSet<>();
        set4 = new HashSet<>();
        generate();

        String[] lines = sc.nextLine().split(",");
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            String s = lines[i];
            for (int j = 3; j < s.length() - 3; j++) {
                if (set3.contains(s.substring(j, j + 3))) {
                    map.put(s, new int[]{i, 2});
                    break;
                }
                if (set4.contains(s.substring(j, j + 3))) {
                    map.put(s, new int[]{i, 1});
                }
            }

            for (int j = 3; j < s.length() - 4; j++) {
                if (set1.contains(s.substring(j, j + 4))) {
                    map.put(s, new int[]{i, 4});
                    break;
                }
                if (set2.contains(s.substring(j, j + 4))) {
                    map.put(s, new int[]{i, 3});
                }
            }

            if (!map.containsKey(s)) {
                map.put(s, new int[]{i, 0});
            }
        }

        List<Map.Entry<String, int[]>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, int[]>>() {
            @Override
            public int compare(Map.Entry<String, int[]> o1, Map.Entry<String, int[]> o2) {
                if (o1.getValue()[1] == o2.getValue()[1]) {
                    return o1.getValue()[0] - o2.getValue()[0];
                } else {
                    return o2.getValue()[1] - o1.getValue()[1];
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue()[1] > 0) {
                sb.append(list.get(i).getKey()).append(",");
            }
        }

        if (list.get(0).getValue()[1] == 0) {
            System.out.println("null");
        } else {
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    public static void generate() {
        set1.add("0000");
        int start = 1111;
        while (start < 10000) {
            set1.add(String.valueOf(start));
            start += 1111;
        }

        set3.add("000");
        start = 111;
        while (start < 1000) {
            set3.add(String.valueOf(start));
            start += 111;
        }

        set2.add("0123");
        start = 1234;
        while (start <= 6789) {
            set2.add(String.valueOf(start));
            start += 1111;
        }
        start = 9876;
        while (start >= 3210) {
            set2.add(String.valueOf(start));
            start -= 1111;
        }

        set4.add("012");
        start = 123;
        while (start <= 789) {
            set4.add(String.valueOf(start));
            start += 111;
        }
        start = 987;
        while (start >= 210) {
            set4.add(String.valueOf(start));
            start -= 111;
        }
    }
}
