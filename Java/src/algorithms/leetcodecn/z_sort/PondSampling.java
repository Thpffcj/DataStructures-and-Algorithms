package algorithms.leetcodecn.z_sort;

import java.util.Random;

/**
 * Created by thpffcj on 2020/3/13.
 */
public class PondSampling {

    public static void main(String[] args) {
        int[] S = new int[10000];
        int N = S.length;
        Random random = new Random();
        // 生成一万个数的数组
        for (int r = 0;r < N; r ++){
            S[r] = random.nextInt(10000);
        }

        int k = 10;
        int[] R = new int[k];
        // S前K个数填充R数组
        for (int f = 0; f < k; f++){
            R[f] = S[f];
        }
        int j ;
        // 遍历数组S,根据算法,替换R数组中的元素,最终生成结果R数组.
        for (int i = k; i < S.length; i++){
            j = random.nextInt(i);
            if (j < k)  {
                R[j] = S[i];
            }
        }
        // 打印R数组的结果
        for (int i =0;i < R.length;i++) {
            System.out.println(R[i]);
        }
    }
}
