package algorithms.algorithmInterview.usingHashTable;

/**
 * Created by Thpffcj on 2018/3/12.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number
 * equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> number = new HashSet<>();
        while (n != 1) {
            int newNumber = 0;
            while (n > 0) {
                newNumber = newNumber + (n % 10) * (n % 10);
                n = n / 10;
            }
            n = newNumber;
            if (number.contains(newNumber)) {
                break;
            }
            number.add(newNumber);
        }
        return n == 1;
    }
}
