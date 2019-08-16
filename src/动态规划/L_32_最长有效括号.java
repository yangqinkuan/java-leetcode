/**
 * FileName: L_最长有效括号
 * Author:   yangqinkuan
 * Date:     2019-8-14 18:04
 * Description:
 */

package 动态规划;

public class L_32_最长有效括号 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        if(s.length()==0){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int res = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }else if(i-dp[i-1]>0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
                res = Math.max(res,dp[i]);
            }


        }
        return res;
    }
}
