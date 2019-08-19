/**
 * FileName: L_155_MinStack
 * Author:   yangqinkuan
 * Date:     2019-5-20 11:17
 * Description:
 */

package 栈;

import java.util.Stack;

/**
 * 最小栈
 */
public class L_155_MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int min;
    public L_155_MinStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty() || stack2.peek()>=x){
            stack2.push(x);
        }
    }

    public void pop() {
        int var1 = stack1.pop();
        if(var1==stack2.peek()){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
