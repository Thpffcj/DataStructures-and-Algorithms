package algorithms.swordRefersToOffer;

/**
 * Created by thpffcj on 2020/1/10.
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularExpressionMatching {

    public boolean match(char[] str, char[] pattern) {

       return isMatch(new String(str), new String(pattern));
    }

    public boolean isMatch(String text, String pattern) {
        System.out.println(text + " " + pattern);
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        char[] str = new char[]{};
        char[] pattern = new char[]{};
        System.out.println(r.match(str, pattern));
    }
}
