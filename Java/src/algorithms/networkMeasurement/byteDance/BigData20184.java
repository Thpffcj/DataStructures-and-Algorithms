package algorithms.networkMeasurement.byteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/1/19.
 *
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，
 * 每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。因为一些特殊的
 * 原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。
 *
 * 输入描述:
 * 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4行
 * 到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,
 * q<=300000 k是整型
 *
 * 输出描述:
 * 输出：一共q行，每行一个整数代表喜好值为k的用户的个数
 *
 * 输入例子1:
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 *
 * 输出例子1:
 * 1
 * 0
 * 2
 *
 * 例子说明1:
 * 样例解释:
 * 有5个用户，喜好值为分别为1、2、3、3、5，
 * 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
 * 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
 * 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
 */
public class BigData20184 {

    /**
     * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
     * case通过率为50.00%
     */
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int[] digit = new int[n];
//        for (int i = 0; i < n; i++) {
//            digit[i] = sc.nextInt();
//        }
//
//        int q = sc.nextInt();
//        while (q > 0) {
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//            int k = sc.nextInt();
//
//            q--;
//
//            int result = 0;
//            for (int i = l - 1; i < r; i++) {
//                if (digit[i] == k) {
//                    result++;
//                }
//            }
//            System.out.println(result);
//        }
//    }

    /**
     * 本题主要在于设计数据结构，数据结构设计错误整个题目会陷入超时的状态
     * 首先关于用户喜好和用户标号对应，其次我们结果需要查询的是根据喜好查询用户标号个数，
     * 那么我们可以将喜好-用户号设计为字典的键值对数据结构，对于同一个喜好的k值作为键，
     * 而键对应的value是同一个喜好的用户值。然后根据输入的用户值起始值和终点值，
     * 以及用户的喜好值可以从这个HashMap中解析出数量。
     * 解析方法：首先根据喜好值取出这个list然后对其遍历找到对应区间即可
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int userTotal = sc.nextInt();
        HashMap<Integer, List<Integer>> like = new HashMap<>();

        for (int i = 1; i <= userTotal; i++) {
            int k = sc.nextInt();
            if (like.containsKey(k)) {
                List<Integer> list = like.get(k);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                like.put(k, list);
            }
        }

        int groupTotal = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < groupTotal; i++) {
            int low = sc.nextInt();
            int high = sc.nextInt();
            int k = sc.nextInt();
            int total = 0;
            List<Integer> list = like.get(k);
            if (list != null) {
                for (Integer integer : list) {
                    if (integer >= low && integer <= high) {
                        total++;
                    }
                }
            }
            result.add(total);
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
