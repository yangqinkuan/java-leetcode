/**
 * FileName: L_225_ImplementStackusingQueues
 * Author:   yangqinkuan
 * Date:     2019-5-20 11:41
 * Description:
 */

package 栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * 用两个队列，每次需要pop 或者peek 对队列进行一次倒斗，留下最后一个值，更换队列指针
 */
public class L_225_ImplementStackusingQueues {
    Queue<Integer> insertQueue;
    Queue<Integer> saveQueue;
    public L_225_ImplementStackusingQueues() {
        insertQueue = new LinkedList<>();
        saveQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
       insertQueue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(insertQueue.size()!=1){
            saveQueue.add(insertQueue.poll());
        }
        int value = insertQueue.poll();
        Queue<Integer> temp = insertQueue;
        insertQueue = saveQueue;
        saveQueue = temp;
        return value;
    }

    /** Get the top element. */
    public int top() {
        while(insertQueue.size()!=1){
            saveQueue.add(insertQueue.poll());
        }
        int value = insertQueue.poll();
        saveQueue.add(value);
        Queue<Integer> temp = insertQueue;
        insertQueue = saveQueue;
        saveQueue = temp;
        return value;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(insertQueue.isEmpty()&&saveQueue.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        L_225_ImplementStackusingQueues temp = new L_225_ImplementStackusingQueues();
        temp.push(1);
        temp.push(2);
        System.out.println(temp.top());
        System.out.println(temp.pop());
        temp.empty();
    }
}
