package algorithms.advancedAlgorithm.homework.homework1;

/**
 * Created by thpffcj on 2019/10/11.
 */

import java.util.*;

/**
 * Description
 * 从一列不重复的数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小的。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入是一个数组，数值通过空格隔开。
 *
 * Output
 * 输出筛选之后的数组，用空格隔开。如果有多种结果，则一行一种结果， 单个输入的所有结果按从小到大排序，排序的key的优先级随
 * index递增而递减 例如 3 4 7 6； 1 3 7 5； 1 2 7 6； 1 3 7 6 排序成 1 2 7 6；1 3 7 5；1 3 7 6； 3 4 7 6；
 *
 * Sample Input 1
 * 4
 * 1 2 4 7 11 10 9 15 3 5 8 6
 * 1 3 5 4 7 6 4 5 3
 * 1 2 3
 * 3 2 1
 *
 * Sample Output 1
 * 1 2 4 7 11 10 9 8 6
 * 1 3 4 7 6 4 3
 * 1 3 4 7 6 5 3
 * 1 3 5 7 6 4 3
 * 1 3 5 7 6 5 3
 * 1 2 3
 * 3 2 1
 */
public class FirstRiseAndThenFall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine().trim());

        while (numbers > 0) {
            int[] input = StringArrayToIntArray(sc.nextLine());

            int[] lis = LIS(input);
            int[] lds = LDS(input);

            int[] maxI = GetMaxArr(lis, lds);
            int MaxLen = GetArrMax(maxI);

            Set<String> setResult = new HashSet<String>();

            for (int j = 0; j < maxI.length; j++) {
                if (maxI[j] == MaxLen) {
                    GetStringResu(GetSetNode(input, lis, lds, j, MaxLen), "", 0, -1, setResult);
                }
            }

            List<String> listResult = new LinkedList<String>(setResult);
            Collections.sort(listResult);
            for (int j = 0; j < listResult.size(); j++) {
                if (IsValid(listResult.get(j))) {
                    System.out.println(listResult.get(j));
                }
            }

            numbers--;
        }
    }

    private static boolean IsValid(String s) {
        int[] input = StringArrayToIntArray(s);
        if (input.length == 1)
            return true;
        boolean isup = true;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1])
                return false;
            if (isup && input[i] < input[i - 1])
                isup = false;
            if (!isup && input[i] > input[i - 1])
                return false;
        }
        return true;
    }

    private static void GetStringResu(List<String>[] listInput, String curStr, int curIndex, int preIndex, Set<String> result) {
        for (int i = curIndex; i < listInput.length; i++) {
            for (int j = 1; j < listInput[i].size(); j++) {
                if (Integer.parseInt(listInput[i].get(j).split("/")[1]) > preIndex)
                    GetStringResu(listInput, curStr + " " + listInput[i].get(j).split("/")[0], i + 1, Integer.parseInt(listInput[i].get(j).split("/")[1]), result);
            }
            if (Integer.parseInt(listInput[i].get(0).split("/")[1]) <= preIndex)
                continue;
            curStr = curStr + " " + listInput[i].get(0).split("/")[0];
            preIndex = Integer.parseInt(listInput[i].get(0).split("/")[1]);
        }
        if (curStr.trim().split(" ").length == listInput.length)
            result.add(curStr.trim());
    }

    private static List<String>[] GetSetNode(int[] input, int[] lis, int[] lds, int slice, int strLen) {
        List<String>[] outList = new List[strLen];
        for (int i = 0; i < outList.length; i++)
            outList[i] = new LinkedList<>();
        for (int i = 0; i < slice; i++)
            outList[lis[i] - 1].add(input[i] + "/" + i);
        for (int i = slice; i < input.length; i++)
            outList[strLen - lds[i]].add(input[i] + "/" + i);
        return outList;
    }

    private static int GetArrMax(int[] arr) {
        if (arr.length == 0)
            throw new IllegalArgumentException();
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > result)
                result = arr[i];
        return result;
    }

    private static int[] GetMaxArr(int[] arr1, int[] arr2) {
        int[] OP = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            OP[i] = arr1[i] + arr2[i] - 1;
        return OP;
    }

    public static int[] LIS(int[] arr) {
        int[] output = new int[arr.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = 1;
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && output[i] < output[j] + 1)
                    output[i] = output[j] + 1;
        }
        return output;
    }

    public static int[] LDS(int[] arr) {
        int[] output = new int[arr.length];
        for (int i = output.length - 1; i >= 0; i--) {
            output[i] = 1;
            for (int j = output.length - 1; j > i; j--)
                if (arr[i] > arr[j] && output[i] < output[j] + 1)
                    output[i] = output[j] + 1;
        }
        return output;
    }

    public static int Sum(int[] arr) {
        int result = 0;
        for (int val : arr)
            result += val;
        return result;
    }

    public static int[] StringArrayToIntArray(String string) {
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
}
