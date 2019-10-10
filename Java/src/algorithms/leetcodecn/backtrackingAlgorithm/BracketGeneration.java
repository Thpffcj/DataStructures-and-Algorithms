package algorithms.leetcodecn.backtrackingAlgorithm;

/**
 * Created by thpffcj on 2019/10/9.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class BracketGeneration {

    public static String LEFT = "(";
    public static String RIGHT = ")";
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        if (n < 1) {
            return null;
        }

        generateParenthesis("", LEFT, n, n, 0);

        return result;
    }

    public void generateParenthesis(String s, String bracket, int left, int right, int pos) {
        if (left == 0 && right == 0 && pos == 0) {
            result.add(s);
        }

        if (bracket.equals(LEFT)) {
            s = s + LEFT;
            pos++;
        } else {
            s = s + RIGHT;
            pos--;
            if (pos < 0) {
                return;
            }
        }

        if (left > 0) {
            generateParenthesis(s, LEFT, left - 1, right, pos);
        }
        if (right > 0) {
            generateParenthesis(s, RIGHT, left, right - 1, pos);
        }
    }



//    public List<String> generateAllString(String s, int left, int right) {
//
//        if (left == 0 && right == 0) {
//            result.add(s);
//            return result;
//        }
//        if (left > 0) {
//            generateAllString(s + LEFT, left - 1, right);
//        }
//        if (right > 0) {
//            generateAllString(s + RIGHT, left, right - 1);
//        }
//        return result;
//    }

    public static void main(String[] args) {
        BracketGeneration b = new BracketGeneration();
        b.generateParenthesis(3);
    }
}
