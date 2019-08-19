/**
 * FileName: L_44_通配符匹配
 * Author:   yangqinkuan
 * Date:     2019-6-25 9:50
 * Description:
 */

package 贪心;

import java.util.concurrent.ConcurrentHashMap;

public class L_44_通配符匹配 {
/*
    dp[i][j]表示s到i位置,p到j位置是否匹配!

    初始化:

    dp[0][0]:什么都没有,所以为true
    第一行dp[0][j],换句话说,s为空,与p匹配,所以只要p开始为*才为true
    第一列dp[i][0],当然全部为False

    动态方程:

    如果(s[i] == p[j] || p[j] == "?") && dp[i-1][j-1] ,有dp[i][j] = true

    如果p[j] == "*" && (dp[i-1][j] = true || dp[i][j-1] = true)有dp[i][j] = true

            ​ note:

            ​ dp[i-1][j],表示*代表是空字符,例如ab,ab*

            ​ dp[i][j-1],表示*代表非空任何字符,例如abcd,ab*   */


    public static boolean isMatch1(String s,String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j=1;j<p.length()+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<p.length()+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }



    public static boolean isMatch(String s, String p) {
        int point1 = 0;
        int point2 = 0;
        int match = 0, starIdx = -1;
        while (point1 < s.length()) {
            if (point2 < p.length() && (p.charAt(point2) == '?' || s.charAt(point1) == p.charAt(point2))) {
                point1++;
                point2++;
            } else if (point2 < p.length() && p.charAt(point2) == '*') {
                starIdx = point2;
                match = point1;
                point2++;
            } else if (starIdx != -1) {
                point2 = starIdx + 1;
                match++;
                point1 = match;
            } else {
                return false;
            }

        }
        while (point2 < p.length() && p.charAt(point2) == '*')
            point2++;
        return point2 == p.length();
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        isMatch(s, p);
    }
}

