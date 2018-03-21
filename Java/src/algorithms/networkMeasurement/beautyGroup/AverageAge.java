package algorithms.networkMeasurement.beautyGroup;

/**
 * Created by Thpffcj on 2018/3/21.
 */

import java.util.Scanner;

/**
 * 已知某公司总人数为W，平均年龄为Y岁(每年3月末计算，同时每年3月初入职新人)，假设每年离职率为x，x>0&&x<1,
 * 每年保持所有员工总数不变进行招聘，新员工平均年龄21岁。
 * 从今年3月末开始，请实现一个算法，可以计算出第N年后公司员工的平均年龄。(最后结果向上取整)。
 *
 * 输入描述:
 * 输入W Y x N
 * 输出描述:
 * 输出第N年后的平均年龄
 *
 * 输入例子1:
 * 5 5 0.2 3
 * 输出例子1:
 * 15
 */
public class AverageAge {

    // TODO 题目表达太模糊，看答案默认离职员工总体也符合平均年龄
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int total = sc.nextInt();
            int age = sc.nextInt();
            double rate = sc.nextDouble();
            int year = sc.nextInt();
            int totalAge = total * age;
            double left = total * rate;
            for (int i = 0; i < year; i++) {

            }
        }
    }
}
