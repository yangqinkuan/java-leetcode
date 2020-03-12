package ACM;


import java.util.Stack;

/**
 * 某种可能的出栈序列是否符合
 * in 为按顺序 12345 进入， 出栈顺序 (5,4,1,2,3)不可能 (5,4,3,2,1)可能
 * 采用双指针的思路和一个辅助栈
 * 1 如果当前栈为空，或者栈顶的值不等于出栈指针所指的值，则入栈
 * 2 如果 等于则出栈，
 * 3 如果 没有可入栈的值了，出栈指针没有到最后，则返回false 其它返回true
 */

public class 铁轨 {

    public static void main(String[] args) {
        铁轨 test = new 铁轨();
        int[] in = new int[]{1,2,3,4,5};
        int[] out = new int[]{1,3,2,4,5};
        System.out.println(test.isOK(in,out));
    }

    public boolean isOK(int[] in,int[] out){
        Stack<Integer> stack = new Stack<>();
        int in_p = 0;
        int out_p = 0;
        while(out_p!=out.length){
            while (stack.size()!=0&&stack.peek()==out[out_p]){
                stack.pop();
                out_p++;
            }
            if(in_p!=in.length){
                stack.add(in[in_p++]);
            }else{
                if(out_p!=out.length) return false;
            }
        }
        return true;
    }
}
