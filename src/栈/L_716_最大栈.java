package 栈;

import java.util.Stack;

public class L_716_最大栈 {
    /** initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int max;
    public L_716_最大栈() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        max = Integer.MIN_VALUE;
    }

    public void push(int x) {
        stack1.add(x);
        max = Math.max(x,max);
    }

    public int pop() {
        int res = stack1.pop();
        max = Integer.MIN_VALUE;
        while(stack1.size()!=0){
            max = Math.max(max,stack1.peek());
            stack2.add(stack1.pop());
        }
        while(stack2.size()!=0){
            stack1.add(stack2.pop());
        }
        return res;
    }

    public int top() {
        return stack1.peek();
    }

    public int peekMax() {
        return max;
    }

    public int popMax() {
        Integer res = null;
        while(stack1.size()!=0){
            if(stack1.peek()==max&&res==null){
                res = stack1.pop();
                continue;
            }
            stack2.add(stack1.pop());
        }
        max = Integer.MIN_VALUE;
        while(stack2.size()!=0){
            max = Math.max(max,stack2.peek());
            stack1.add(stack2.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        L_716_最大栈 stack = new L_716_最大栈();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        stack.top();
        stack.popMax();
        stack.top();
        stack.peekMax();
        stack.pop();
        stack.top();


    }
}
