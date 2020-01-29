package algorithms.swordRefersToOffer;

import java.util.Stack;

/**
 * Created by thpffcj on 2019/9/16.
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Offer30 {

    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack();

    public void push(int node) {
        if (stack.isEmpty()) {
            stack.push(node);
            minStack.push(node);
        } else {
            stack.push(node);
            int min = minStack.peek();
            if (min > node) {
                minStack.push(node);
            } else {
                minStack.push(min);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
