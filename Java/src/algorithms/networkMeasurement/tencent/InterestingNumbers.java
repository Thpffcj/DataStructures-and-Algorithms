package algorithms.networkMeasurement.tencent;

import java.util.*;

/**
 * Created by thpffcj on 2020/1/26.
 *
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
 *
 * 输入描述:
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * N - 本组测试数据有n个数
 * a1,a2...an - 需要计算的数据
 * 保证：1<=N<=100000,0<=ai<=INT_MAX.
 *
 * 输出描述:
 * 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
 *
 * 输入例子1:
 * 6
 * 45 12 45 32 5 6
 *
 * 输出例子1:
 * 1 2
 */
public class InterestingNumbers {

    /**
     * 先排序，如果排序后发现数字中所有数字都相同，直接输出结果：差最大个数 = 差最小个数 = （n * (n-1))/2;(两两组合)
     * 统计数组中每个数字出现的次数(用map)
     * 计算差最小个数：如果数组中没有重复数字，说明最小差不为0，最小差是数组中相邻两个数的差；
     *   如果数组中有重复数字，说明最小差是0，此时，遍历一边map，数字个数不为0的数字会产生最小差0。
     * 计算差最大个数：最大值与最小值的两两组合，即最大值个数 * 最小值个数。
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            // 如果数组中的值全相同，直接两两组合
            if(a[0] == a[n - 1]){
                int tmp = (n * (n - 1)) / 2;
                System.out.println(tmp + " " + tmp);
                continue;
            }

            // map用来统计
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for(int i = 0; i < n; i++){
                if(map.containsKey(a[i]))
                    map.put(a[i], map.get(a[i]) + 1);
                else
                    map.put(a[i], 1);
            }

            // 求差最小个数
            int minres = 0;
            if(map.size() == n){
                int min = Math.abs(a[1] - a[0]);
                for(int i = 1; i < n; i++){
                    int tmp = Math.abs(a[i] - a[i - 1]);
                    if(tmp == min)
                        minres++;
                    else if(tmp < min){
                        min = tmp;
                        minres = 1;
                    }
                }
            } else {
                for(Integer key : map.keySet()){
                    int val = map.get(key);
                    if(val > 1){
                        minres += (val * (val - 1)) / 2;
                    }
                }
            }

            // 求差最大个数
            int maxres = 0;
            List<Integer> keySet = new ArrayList<>(map.keySet());
            int val1 = map.get(keySet.get(0));
            int val2 = map.get(keySet.get(keySet.size() - 1));
            maxres = val1 * val2;
            System.out.println(minres + " " + maxres);
        }
    }
}
