package algorithms.masterOnlineExam.zhaohang;

import java.util.*;

/**
 * Created by thpffcj on 2020/3/27.
 *
 * 2
 * 5
 * 4 9 5 2 2
 * 1 3 5 1 4
 * 3
 * 2 1 2
 * 2 1 2
 *
 * 2
 * 1
 */
public class ZhaoHang20202 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int n = sc.nextInt();
            int[] length = new int[n];
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                length[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }

            Map<Integer, int[]> map1 = new HashMap<>();
            Map<Integer, int[]> map2 = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map1.put(i, new int[]{length[i], weight[i]});
                map2.put(i, new int[]{length[i], weight[i]});
            }

            List<Map.Entry<Integer, int[]>> list1 = new ArrayList<>(map1.entrySet());
            Collections.sort(list1, new Comparator<Map.Entry<Integer, int[]>>() {
                @Override
                public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                    if (o1.getValue()[0] == o2.getValue()[0]) {
                        return o1.getValue()[1] - o2.getValue()[1];
                    } else {
                        return o1.getValue()[0] - o2.getValue()[0];
                    }
                }
            });

            List<Map.Entry<Integer, int[]>> list2 = new ArrayList<>(map2.entrySet());
            Collections.sort(list2, new Comparator<Map.Entry<Integer, int[]>>() {
                @Override
                public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                    if (o1.getValue()[1] == o2.getValue()[1]) {
                        return o1.getValue()[0] - o2.getValue()[0];
                    } else {
                        return o1.getValue()[1] - o2.getValue()[1];
                    }
                }
            });

            int result1 = 1;
            int l1 = list1.get(0).getValue()[0];
            int w1 = list1.get(0).getValue()[1];
            for (Map.Entry<Integer, int[]> entry : list1) {
                int[] digit = entry.getValue();
                if (digit[0] < l1 || digit[1] < w1) {
                    result1++;
                }
                l1 = digit[0];
                w1 = digit[1];
            }

            int result2 = 1;
            int l2 = list2.get(0).getValue()[0];
            int w2 = list2.get(0).getValue()[1];
            for (Map.Entry<Integer, int[]> entry : list2) {
                int[] digit = entry.getValue();
                if (digit[0] < l2 || digit[1] < w2) {
                    result2++;
                }
                l2 = digit[0];
                w2 = digit[1];
            }

            System.out.println(Math.min(result1, result2));
        }
    }
}
