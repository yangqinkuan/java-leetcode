/**
 * FileName: L_682_BaseballGame
 * Author:   yangqinkuan
 * Date:     2019-5-20 17:45
 * Description:
 */

package 栈;

import java.util.Stack;

public class L_682_BaseballGame {
    public int calPoints(String[] ops) {
        if(ops==null){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String s: ops) {
            if(s.equals("+")){
                int x = 0;
                int y = 0;
                if(!stack.isEmpty()){
                    x = stack.pop();
                }
                if(!stack.isEmpty()){
                    y = stack.peek();
                    stack.add(x);
                }
                stack.add(x+y);
                continue;

            }

            if(s.equals("D")){
                stack.add(stack.peek()*2);
                continue;
            }
            if(s.equals("C")){
                stack.pop();
                continue;
            }
            stack.add(Integer.parseInt(s));
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    /**
     * 推荐解法
     * @param ops
     * @return
     */
    public int calPoints1(String[] ops) {
        int[] arr = new int[ops.length];
        int i=0;
        for(String s:ops){
            switch (s){
                case "+":arr[i]=arr[i-1]+arr[i-2];i++;break;
                case "D":arr[i]=2*arr[i-1];i++;break;
                case "C":arr[i-1]=0;i--;break;
                default:
                    arr[i]=Integer.valueOf(s);
                    i++;
            }
        }
        int sum=0;
        for (int j = 0; j <arr.length ; j++) {
            sum+=arr[j];
        }
        return sum;
    }
}
