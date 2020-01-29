package algorithms.swordRefersToOffer;

import java.util.ArrayList;

/**
 * Created by thpffcj on 2019/9/16.
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Offer29 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int columns = matrix[0].length;
        int rows = matrix.length;
        int start = 0;

        while (columns > start * 2 && rows > start * 2) {
            printMatrixInCircle(matrix, columns, rows, start, result);
            start++;
        }
        return result;
    }

    void printMatrixInCircle(int [][] matrix, int columns, int rows, int start, ArrayList<Integer> result) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            result.add(matrix[start][i]);
        }

        // 从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }
        }

        // 从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                result.add(matrix[endY][i]);
            }
        }

        // 从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                result.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        Offer29 clockwisePrintingMatrix = new Offer29();
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        clockwisePrintingMatrix.printMatrix(matrix);
    }
}
