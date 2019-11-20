package algorithms.advancedAlgorithm.homework.homework3;

import java.util.*;

/**
 * Created by thpffcj on 2019/11/18.
 */

/**
 * Description
 * 棋盘覆盖问题：给定一个大小为2^n2^n个小方格的棋盘，其中有一个位置已经被填充，现在要用一个L型（22个小方格组成的大方格中去掉
 * 其中一个小方格）形状去覆盖剩下的小方格。求出覆盖方案，即哪些坐标下的小方格使用同一个L型格子覆盖。注意：坐标从0开始。左上方
 * 的第一个格子坐标为(0,0)，第一行第二个坐标为(0,1)，第二行第一个为(1,0)，以此类推。
 *
 * Input
 * 输入第一行为测试用例个数，后面每一个用例有两行，第一行为n值和特殊的格子的坐标（用空格隔开），第二行为需要查找其属于同一个L
 * 型格子的格子坐标。
 *
 * Output
 * 输出每一行为一个用例的解，先按照行值从小到大、再按照列值从小到大的顺序输出每一个用例的两个坐标；用逗号隔开。
 *
 * Sample Input 1
 * 1
 * 1 1 1
 * 0 0
 *
 * Sample Output 1
 * 0 1,1 0
 */
public class BoardCoverageProblem {

    public static int[][] board;
    public static int LNumber = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        while (numbers > 0) {
            int n = sc.nextInt();
            int size = (int) Math.pow(2, n);
            int specialROW = sc.nextInt();
            int specialCOL = sc.nextInt();
            board = new int[size][size];

            setBoard(specialROW, specialCOL, 0, 0, size);

            int x = sc.nextInt();
            int y = sc.nextInt();

            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[i][j] == board[x][y]) {
                        if (!(i == x && j == y)) {
                            list.add(i + " " + j);
                        }
                    }
                }
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0)).append(",").append(list.get(1));

            System.out.println(sb);

            numbers--;
        }
    }

    /**
     *
     * @param specialROW 特殊点的行下标
     * @param specialCOL 特殊点的列下标
     * @param leftROW 矩阵的左边起点行下标
     * @param leftCOL 矩阵左边起点的列下标
     * @param size 矩阵的宽或者高
     */
    public static void setBoard(int specialROW, int specialCOL, int leftROW, int leftCOL, int size) {

        if (size == 1) {
            return;
        }

        int subSize = size / 2;
        LNumber++;
        int n = LNumber;

        // 假设特殊点在左上角区域
        if (specialROW < leftROW + subSize && specialCOL < leftCOL + subSize) {
            setBoard(specialROW, specialCOL, leftROW, leftCOL, subSize);
        } else {
            // 不在左上角，设左上角矩阵的右下角就是特殊点（和别的一起放置L形）
            board[leftROW + subSize - 1][leftCOL + subSize - 1] = n;
            setBoard(leftROW + subSize - 1, leftCOL + subSize - 1, leftROW, leftCOL, subSize);
        }

        // 假设特殊点在右上角区域
        if (specialROW < leftROW + subSize && specialCOL >= leftCOL + subSize) {
            setBoard(specialROW, specialCOL, leftROW, leftCOL + subSize, subSize);
        } else {
            board[leftROW + subSize - 1][leftCOL + subSize] = n;
            setBoard(leftROW + subSize - 1, leftCOL + subSize, leftROW, leftCOL + subSize, subSize);
        }

        // 假设特殊点在左下角区域
        if (specialROW >= leftROW + subSize && specialCOL < leftCOL + subSize) {
            setBoard(specialROW, specialCOL, leftROW + subSize, leftCOL, subSize);
        } else {
            board[leftROW + subSize][leftCOL + subSize - 1] = n;
            setBoard(leftROW + subSize, leftCOL + subSize - 1, leftROW + subSize, leftCOL, subSize);
        }

        // 假设特殊点在右下角区域
        if (specialROW >= leftROW + subSize && specialCOL >= leftCOL + subSize) {
            setBoard(specialROW, specialCOL, leftROW + subSize, leftCOL + subSize, subSize);
        } else {
            board[leftROW + subSize][leftCOL + subSize] = n;
            setBoard(leftROW + subSize, leftCOL + subSize, leftROW + subSize, leftCOL + subSize, subSize);
        }
    }
}
