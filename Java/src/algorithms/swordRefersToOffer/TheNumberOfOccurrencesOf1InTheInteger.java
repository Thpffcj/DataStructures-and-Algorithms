package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/14.
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现
 * 6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出
 * 现的次数）。
 */
public class TheNumberOfOccurrencesOf1InTheInteger {

    public int NumberOf1Between1AndN_Solution(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }

        int high = Integer.parseInt(String.valueOf(n).substring(0, 1));
        int last = Integer.parseInt(String.valueOf(n).substring(1));
        int power = (int) Math.pow(10, String.valueOf(n).length() - 1);

        if (high == 1) {
            return NumberOf1Between1AndN_Solution(last) + NumberOf1Between1AndN_Solution(power - 1)
                    + last + 1;
        } else {
            return power + high * NumberOf1Between1AndN_Solution(power - 1) + NumberOf1Between1AndN_Solution(last);
        }
    }

    public static void main(String[] args) {
        TheNumberOfOccurrencesOf1InTheInteger t = new TheNumberOfOccurrencesOf1InTheInteger();
        System.out.println(t.NumberOf1Between1AndN_Solution(10));
    }
}
