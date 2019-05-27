/**
 * FileName: L_232_ImplementQueueUsingStacks
 * Author:   yangqinkuan
 * Date:     2019-5-20 12:16
 * Description:
 */

package 栈;

import java.util.Stack;

public class L_232_ImplementQueueUsingStacks {
    Stack<Integer> instack;
    Stack<Integer> outstack;
    public L_232_ImplementQueueUsingStacks() {
        instack = new Stack<>();
        outstack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        instack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                outstack.add(instack.pop());
            }
        }
        return outstack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                outstack.add(instack.pop());
            }
        }
        return outstack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(instack.isEmpty()&&outstack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
