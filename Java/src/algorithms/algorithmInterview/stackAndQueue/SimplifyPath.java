package algorithms.algorithmInterview.stackAndQueue;

/**
 * Created by Thpffcj on 2018/3/15.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack stack = new Stack();
        String[] origin = path.split("/");
        for (int i = 0; i < origin.length; i++) {
            if (origin[i].equals(" ") || origin[i].equals("") || origin[i].equals(".")) {
                continue;
            }
            if (origin[i].equals("..")) {
                if (!stack.empty()) {
//                    stack.pop();
                    stack.pop();
                }
                continue;
            }
//            stack.push("/");
            stack.push(origin[i]);
        }
        // 解法一：自己搞出栈
//        String reverse = "";
//        while (!stack.empty()) {
//            reverse = reverse + stack.pop();
//        }
//        String[] re = reverse.split("/");
//        String result = "/";
//        for (int i = 0; i < re.length - 1; i++) {
//            result = result + re[re.length - 1 - i] + "/";
//        }
//        result = result + re[0];

        // 解法二：直接利用构造方法处理栈
        List<String> list = new ArrayList(stack);
        String result =  "/" + String.join("/", list);
        return result;
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        simplifyPath.simplifyPath("/");
    }
}
