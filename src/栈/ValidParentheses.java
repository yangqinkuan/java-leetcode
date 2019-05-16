/**
 * FileName: ValidParentheses
 * Author:   yangqinkuan
 * Date:     2019-5-13 12:18
 * Description:
 */

package 栈;

import java.util.Stack;
/*leetcode 20*/
public class ValidParentheses {
/*
*   采用栈的思路,
*   1、若待入栈符号与栈顶符号配对，则取出栈顶，当前也不入栈
*   若栈符号与栈顶符号不配对，则入栈，
*
*   2、遍历完成后，若栈为大小为0，则返回true，不为0返回false
* */
    public boolean isValid(String s) {
        if(s==null){
            return false;
        }
        if(s.equals("")){
            return true;
        }
        Stack stack = new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int num = getNum(c);
            if(stack.size()==0){
                stack.push(num);
                continue;
            }
            if(((int)stack.peek()+num)==0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }


    private int getNum(char c){
        switch (c){
            case '[':
                return 1;
            case ']':
                return -1;
            case '(':
                return 2;
            case ')':
                return -2;
            case '{':
                return 3;
            case '}':
                return -3;
            default:
                return 0;

        }
    }

    public static void main(String[] args) {

    }
}
