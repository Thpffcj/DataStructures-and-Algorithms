package algorithms.networkMeasurement.beautyGroup;

/**
 * Created by Thpffcj on 2018/3/21.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 对于一个由0..n的所有数按升序组成的序列，我们要进行一些筛选，每次我们取当前所有数字中从小到大的第奇数位个的数，并将其丢弃。
 * 重复这一过程直到最后剩下一个数。请求出最后剩下的数字。
 *
 * 输入描述:
 * 每组数据一行一个数字，为题目中的n(n小于等于1000)。
 * 输出描述:
 * 一行输出最后剩下的数字。
 *
 * 输入例子1:
 * 500
 * 输出例子1:
 * 255
 */
public class OddBitsDiscarded {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<Integer> res = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i <= n; i++) {
                res.add(i);
            }
            while (res.size() > 1) {
                int pos = (res.size() - 1) % 2 == 0 ? res.size() - 1 : res.size() - 2;
                while (pos >= 0) {
                    res.remove(pos);
                    pos = pos - 2;
                }
            }
            System.out.println(res.get(0));
        }
    }
}
