/**
 * FileName: L_150_EvaluateReversePolishNotation
 * Author:   yangqinkuan
 * Date:     2019-5-20 11:12
 * Description:
 */

package 栈;

import java.util.Stack;

/**
 * 波兰表达式
 */
public class L_150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            switch (s){
                case "+":
                    stack.add(stack.pop()+stack.pop());
                    break;
                case "-":
                    int temp1 = stack.pop();
                    stack.add(stack.pop()-temp1);
                    break;
                case "*":
                    stack.add(stack.pop()*stack.pop());
                    break;
                case "/":
                    int temp2 = stack.pop();
                    stack.add(stack.pop()/temp2);
                    break;
                default:
                    stack.add(Integer.parseInt(s));
            }

        }
        return stack.pop();
    }
}
