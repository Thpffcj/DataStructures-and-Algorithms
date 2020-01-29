package algorithms.swordRefersToOffer;

import java.util.*;

/**
 * Created by thpffcj on 2019/10/1.
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个
 * 数字能排成的最小数字为321323。
 */
public class Offer45 {

    public String PrintMinNumber(int[] numbers) {

        if(numbers == null || numbers.length == 0) {
            return "";
        }

        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2){
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
