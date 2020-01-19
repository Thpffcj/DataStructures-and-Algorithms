package algorithms.networkMeasurement.byteDance;

import java.util.*;

/**
 * Created by thpffcj on 2020/1/17.
 *
 * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所
 * 有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 *
 * 输入描述:
 * 第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
 * 对于 50%的数据,  1 <= N <= 10000;
 * 对于 100%的数据, 1 <= N <= 500000;
 *
 * 输出描述:
 * 输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。
 *
 * 输入例子1:
 * 5
 * 1 2
 * 5 3
 * 4 6
 * 7 5
 * 9 0
 *
 * 输出例子1:
 * 4 6
 * 7 5
 * 9 0
 *
 */
public class BigData20181 {

    /**
     * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
     * case通过率为60.00%
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (map.containsKey(x)) {
                    if (map.get(x) < y) {
                        map.put(x, y);
                    }
                } else {
                    map.put(x, y);
                }
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getKey() - o1.getKey();
                }
            });

            List<String> result = new ArrayList<>();
            int high = list.get(0).getValue();
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() >= high) {
                    high = entry.getValue();
                    result.add(entry.getKey() + " " + entry.getValue());
                }
            }
            Collections.reverse(result);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }
}
