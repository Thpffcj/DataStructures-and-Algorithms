package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/30.
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Offer64 {

    public int Sum_Solution(int n) {

        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
