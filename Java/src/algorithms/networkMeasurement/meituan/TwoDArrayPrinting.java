package algorithms.networkMeasurement.meituan;

/**
 * Created by Thpffcj on 2018/3/21.
 */

/**
 * 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
 * 给定一个二位数组arr及题目中的参数n，请返回结果数组。
 *
 * 测试样例：
 * [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
 * 返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 */
public class TwoDArrayPrinting {

    /**
     * 沿着主对角线打印，所以每次打印之后x与y都要加1，直到x或y超出边界。
     * 每轮遍历的起始点，是遵循(0,n-1)...(0,0)...(n-1,0)。也就是y先减小到0，然后x增加到n-1。所以遍历的终止条件是startX>=n。
     * @param arr
     * @param n
     * @return
     */
    public int[] arrayPrint(int[][] arr, int n) {
        int[] res = new int[n * n];
        int pos = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = 0;
            int y = i;
            while (y <= n - 1) {
                res[pos] = arr[x][y];
                pos++;
                x++;
                y++;
            }
        }
        for (int j = 1; j <= n - 1; j++) {
            int x = j;
            int y = 0;
            while (x <= n - 1) {
                res[pos] = arr[x][y];
                pos++;
                x++;
                y++;
            }
        }
        return res;
    }
}
