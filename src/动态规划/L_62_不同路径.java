/**
 * FileName: L_62_不同路径
 * Author:   yangqinkuan
 * Date:     2019-12-13 15:27
 * Description:
 */

package 动态规划;

/**
 *
 */
public class L_62_不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[n+1][m+1];
        dp[1][1] = 1;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(i==1&&j==1) continue;
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}
