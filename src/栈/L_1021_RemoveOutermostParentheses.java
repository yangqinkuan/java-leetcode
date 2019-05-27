/**
 * FileName: L_1021_RemoveOutermostParentheses
 * Author:   yangqinkuan
 * Date:     2019-5-20 19:18
 * Description:
 */

package 栈;

/**
 * 删除最外层括号
 */
public class L_1021_RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        int length = S.length();
        int count = 0;
        int left = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            if(S.charAt(i)=='('){
                count++;
            }else {
                count--;
            }
            if(count==0){
                sb.append(S.substring(left+1,i));
                left=i+1;
            }
        }
        return sb.toString();
    }
}
