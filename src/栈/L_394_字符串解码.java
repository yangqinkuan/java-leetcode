/**
 * Copyright (C), 2018-2019,
 * FileName: L_394_字符串解码
 * Author:   Administrator
 * Date:     2019/8/17 16:56
 * Description:
 */
package 栈;

import java.util.*;

public class L_394_字符串解码 {


    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c!=']'){
                stack.add(c);
            }else {
                LinkedList<Character> list = new LinkedList<>();
                while (stack.peek()!='['){
                    list.addFirst(stack.pop());
                }

                stack.pop();
                int count = 0;
                int index = 1;
                while(stack.size()!=0&&stack.peek()<='9'&&stack.peek()>='0'){
                    count  = (stack.pop()-'0')*index+count;
                    index *= 10;
                }
                while(count!=0){
                    stack.addAll(list);
                    count--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(stack.toArray());
        sb.reverse();
        return sb.toString();
    }
}