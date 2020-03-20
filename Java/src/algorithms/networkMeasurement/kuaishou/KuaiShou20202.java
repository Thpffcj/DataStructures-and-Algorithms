package algorithms.networkMeasurement.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/19.
 *
 * 给定一个32位int型正整数，我们定义如下操作，取其十进制各位数字的平方和，并不断重复这个操作。如果某次操作完成后得到的结果是1，
 * 则返回true；否则继续执行，直到证明永远不会得到结果为1，返回false
 * input:19
 * output:true
 *
 * 原因：
 * 1^2 + 9^2=82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 输入描述:
 * 输入一个m(1<=m<=1000)，表示查询组数。
 * 接下来m行，每一行为一个32位int型正整数。
 *
 * 输出描述:
 * 对于每次查询，如果满足题目描述，则输出"true"，反之输出"false" (不要输出引号)
 *
 * 输入例子1:
 * 2
 * 19
 * 7
 *
 * 输出例子1:
 * true
 * true
 */
public class KuaiShou20202 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int num = sc.nextInt();
            if(isSumOne(num))    {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }

    private static boolean isSumOne(int num){
        List<Integer> list = new ArrayList<>();
        int sum = num;
        while(sum != 1){
            sum = getSum(sum);
            if(list.contains(sum)) {
                return false;
            } else {
                list.add(sum);
            }
        }
        return true;
    }

    private static int getSum(int num){
        int sum = 0;
        while(num > 0){
            int last = num % 10;
            sum += last * last;
            num /= 10;
        }
        return sum;
    }
}

