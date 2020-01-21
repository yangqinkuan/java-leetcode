/**
 * FileName: Test01
 * Author:   yangqinkuan
 * Date:     2020-1-2 11:35
 * Description:
 */

package test;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        //System.out.println(f("(()())(())(()(()))"));
        System.out.println();
        Test01 test01 = new Test01();


    }
    public static String f(String s){
        Stack<Integer> stack = new Stack<>();
        String rs = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else {
                int t = stack.pop();
                if(stack.empty()){
                    rs += s.substring(t+1,i);
                }
            }
        }
        return rs;
    }




}
