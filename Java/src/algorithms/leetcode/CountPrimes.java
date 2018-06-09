package algorithms.leetcode;

/**
 * Created by Thpffcj on 2018/6/5.
 */

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

    // 超时
//    public int countPrimes(int n) {
//        int result = 0;
//        for (int i = 1; i < n; i++) {
//            if (isPrime(i)) {
//                result++;
//            }
//        }
//        return result;
//    }
//
//    public boolean isPrime(int n) {
//        if (n == 1) {
//            return false;
//        }
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * 我们从2开始遍历到根号n，先找到第一个质数2，然后将其所有的倍数全部标记出来，然后到下一个质数3，标记其所有倍数，一次类推，
     * 直到根号n，此时数组中未被标记的数字就是质数。我们需要一个n-1长度的bool型数组来记录每个数字是否被标记，长度为n-1的原因
     * 是题目说是小于n的质数个数，并不包括n
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = i * i; j < n && i < Math.sqrt(n); j += i) {
                    notPrime[j] = true;
                }
            }
        }

        return count;
    }
}
