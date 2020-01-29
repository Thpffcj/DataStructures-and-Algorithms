package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019-07-28.
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Offer4 {

    public boolean Find(int target, int [][] array) {

        if (array == null) {
            return false;
        }

        int row = array.length;
        int column = array[0].length;
        int m = 0;
        int n = column - 1;

        while ((m < row) && (n >= 0)) {
            if (array[m][n] == target) {
                return true;
            } else if (array[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
