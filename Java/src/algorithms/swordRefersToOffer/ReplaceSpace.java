package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2019-07-29.
 */

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为
 * We%20Are%20Happy。
 */
public class ReplaceSpace {

//    public String replaceSpace(StringBuffer str) {
//        String result = "";
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ' ') {
//                result += "%20";
//            } else {
//                result += str.charAt(i);
//            }
//        }
//        return result;
//    }

    public String replaceSpace(StringBuffer str) {
       int n = 0;
       int length = str.length();
       for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) == ' ') {
               n++;
               str.append('#');
               str.append('#');
           }
       }

       int second = str.length() - 1;
       for (int first = length - 1; first >= 0; first--) {
           if (first == second) {
               return str.toString();
           }
           if (str.charAt(first) == ' ') {
               str.setCharAt(second--, '0');
               str.setCharAt(second--, '2');
               str.setCharAt(second--, '%');
           } else {
               str.setCharAt(second--, str.charAt(first));
           }
       }
       return str.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace(new StringBuffer(" We are happy")));
    }
}
