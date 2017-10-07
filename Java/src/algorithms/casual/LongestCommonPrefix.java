package algorithms.casual;

/**
 * Created by Thpffcj on 2017/7/31.
 */

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length == 0) {
            return result;
        }
        int length = strs.length;
        int maxlength = Integer.MAX_VALUE;
        int location = 0;
        for(int i=0; i<length; i++) {
            if (strs[i].length() < maxlength) {
                maxlength = strs[i].length();
                location = i;
            }
        }
        for(int i=0; i<maxlength; i++) {
            char temp = strs[location].charAt(i);
            for(int j=0; j<length; j++) {
                if(temp != strs[j].charAt(i)) {
                    return result;
                }
            }
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = new String[3];
        strs[0] = "abcd";
        strs[1] = "abcdes";
        strs[2] = "abcds";
        String result = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(result);
    }
}
