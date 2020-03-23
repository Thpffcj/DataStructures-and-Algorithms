package algorithms.networkMeasurement.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thpffcj on 2020/3/19.
 *
 * 给定一个未排序数组,找出其中最长的等差数列(无需保证数字顺序)。
 *
 * 输入描述:
 * 第一行N表示数组中元素个数（N < 10,000,000）
 *
 * 第二行是数组的元素，用空格分割
 *
 * 输出描述:
 * 等差序列长度
 *
 * 输入例子1:
 * 5
 * 1 4 2 5 3
 *
 * 输出例子1:
 * 5
 */
public class KuaiShou20206 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] arr = new int[num];
        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int maxLen = 1;
        int interval = 0;
        int max = 1;
        for(int i = 0; i < num; i++){
            while(interval <= arr[num - 1] - arr[i]){
                int cur = arr[i];
                for(int j = 1; j < num; j++){
                    if(arr[j] == cur + interval){
                        cur = arr[j];
                        max++;
                    }
                }

                maxLen = max > maxLen ? max : maxLen;
                max = 1;
                interval++;
            }
            interval = 0;
        }
        System.out.println(maxLen);
    }
}
