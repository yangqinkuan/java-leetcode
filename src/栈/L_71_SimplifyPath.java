/**
 * FileName: L_71_SimplifyPath
 * Author:   yangqinkuan
 * Date:     2019-5-16 16:58
 * Description:
 */

package 栈;

import java.util.Stack;

public class L_71_SimplifyPath {
    /* 简化路径
    思路:进进出出的问题 用栈解决
    . 表示本身
    .. 表示上一级
    现将字符串用 / 分割
    然后遍历，
    ..出栈一一层
    .不变
    字符 进栈
    * */
    public String simplifyPath(String path) {
        Stack<String> stack1 = new Stack<>();
        String[] stringArr = path.split("/");
        for(int i=0;i<stringArr.length;i++){
            if(stringArr[i].equals("")){
                continue;
            }
            if(stringArr[i].equals(".")){
                continue;
            }
            if((stringArr[i].equals(".."))){
                if(stack1.size()!=0){
                    stack1.pop();
                }
            }else {
                stack1.add(stringArr[i]);
            }

        }

        Stack<String> stack2 = new Stack<>();
        while(stack1.size()!=0){
            stack2.push(stack1.pop());
        }
        StringBuffer sb = new StringBuffer();
        if(stack2.size()==0){
            sb.append("/");
        }else{
            while(stack2.size()!=0){
                sb.append("/");
                sb.append(stack2.pop());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new L_71_SimplifyPath().simplifyPath("/home//foo/");
    }
}
