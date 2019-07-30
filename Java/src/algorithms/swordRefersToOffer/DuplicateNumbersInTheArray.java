package algorithms.swordRefersToOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by thpffcj on 2019-07-27.
 */

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数
 * 字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的
 * 数字2。
 */
public class DuplicateNumbersInTheArray {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

//    public boolean duplicate(int numbers[],int length,int [] duplication) {
//
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < length; i++) {
//            if (set.contains(numbers[i])) {
//                duplication[0] = numbers[i];
//                return true;
//            } else {
//                set.add(numbers[i]);
//            }
//        }
//        return false;
//    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }

        return false;
    }
}
