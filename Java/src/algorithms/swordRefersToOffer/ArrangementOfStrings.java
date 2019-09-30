package algorithms.swordRefersToOffer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import sun.lwawt.macosx.CPrinterDevice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by thpffcj on 2019/9/24.
 */

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class ArrangementOfStrings {

    public ArrayList<String> Permutation(String str) {

        StringBuffer sb = new StringBuffer(str);
        ArrayList<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        if (str == null || str.equals("")) {
            return result;
        }

        stringPermutation(result, set, "", str);

        result.forEach(s -> System.out.println(s));

        return result;
    }

    public void stringPermutation(ArrayList<String> result, Set<String> set, String s, String str) {
        if (str == null || str.equals("")) {
            if (set.contains(s)) {
                return;
            }
            set.add(s);
            result.add(s);
            return;
        }
        StringBuffer sb = new StringBuffer(str);

        for (int i = 0; i < sb.length(); i++) {
            stringPermutation(result, set, s + sb.charAt(i) + "",
                    sb.substring(0, i) + sb.substring(i + 1, sb.length()));
        }
    }

    public static void main(String[] args) {
        ArrangementOfStrings a = new ArrangementOfStrings();
        a.Permutation("aa");
    }
}
