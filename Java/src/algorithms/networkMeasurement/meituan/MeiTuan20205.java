package algorithms.networkMeasurement.meituan;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by thpffcj on 2020/3/11.
 *
 * 给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，现在要对这个表达式进行
 * 布尔求值，计算结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）。表达式求值是注意and 的
 * 优先级比 or 要高，比如：true or false and false，等价于 true or (false and false)，计算结果是 true。
 *
 * 输入描述:
 * 输入第一行包含布尔表达式字符串s，s只包含true、false、and、or几个单词（不会出现其它的任何单词），且单词之间用空格分隔。
 * (1 ≤ |s| ≤ 103).
 *
 * 输出描述:
 * 输出true、false或error，true表示布尔表达式计算为真，false表示布尔表达式计算为假，error表示一个不合法的表达式。
 *
 * 输入例子1:
 * and
 * 输出例子1:
 * error
 *
 * 输入例子2:
 * true and false
 * 输出例子2:
 * false
 *
 * 输入例子3:
 * true or false and false
 * 输出例子3:
 * true
 */
public class MeiTuan20205 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        Stack<String> stack = new Stack<>();

        for (int i = 0;i < s.length; i++){
            String curr = s[i];
            // 当前值为true或false时
            if (curr.equals("true") || curr.equals("false")){
                if (stack.isEmpty()){
                    stack.push(curr);
                } else {
                    String top = stack.peek();
                    if(top.equals("true") || top.equals("false")){
                        System.out.println("error");
                        return;
                    } else {
                        if (top.equals("or")) {
                            stack.push(curr);
                        } else if (top.equals("and")) {
                            stack.pop();
                            String pre = stack.pop();
                            if(curr.equals("false") || pre.equals("false")) {
                                stack.push("false");
                            } else {
                                stack.push("true");
                            }
                        }
                    }
                }
            } else{  // 当前值为and或or时
                if (stack.isEmpty()) {
                    System.out.println("error");
                    return;
                } else {
                    String top = stack.peek();
                    if(top.equals("and") || top.equals("or")){
                        System.out.println("error");
                        return;
                    }
                    stack.push(curr);
                }
            }
        }

        if(!stack.isEmpty() && (stack.peek().equals("or") || stack.peek().equals("and"))){
            System.out.println("error");
            return;
        }
        while(!stack.isEmpty()){
            String curr = stack.pop();
            if(curr.equals("true")){
                System.out.println("true");
                break;
            }
            if(stack.isEmpty()) {
                System.out.println("false");
            }
        }
    }
}
