package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019/9/28.
 */

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续
 * 的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很
 * 快的找出所有和为S的连续正数序列? Good Luck!
 */
public class AndContinuousPositiveSequenceOfS {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        if (sum <= 0) {
            return null;
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int start = 1;

        while (start < sum) {
            start++;
        }

        return results;
    }
}
