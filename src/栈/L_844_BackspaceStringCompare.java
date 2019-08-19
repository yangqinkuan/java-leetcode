/**
 * FileName: L_844_BackspaceStringCompare
 * Author:   yangqinkuan
 * Date:     2019-5-20 18:45
 * Description:
 */

package 栈;

import java.util.Stack;

public class L_844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack stackS = new Stack<>();
        Stack stackT = new Stack<>();
        char[] cS = S.toCharArray();
        char[] cT = T.toCharArray();
        m1(cS,stackS);
        m1(cT,stackT);
        if(stackS.size()!=stackT.size()){
            return false;
        }
        while(!stackS.isEmpty()){
            if(stackS.pop()!=stackT.pop()){
                return false;
            }
        }
        return true;
    }
    private void m1(char[] temp,Stack stack){
        for (char s: temp) {
            if(s=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.add(s);
            }
        }
    }
}
