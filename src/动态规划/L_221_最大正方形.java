/**
 * FileName: L_221_最大正方形
 * Author:   yangqinkuan
 * Date:     2019-8-15 11:06
 * Description:
 */

package 动态规划;

public class L_221_最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i][j] = matrix[i][j]-'0';
                res = Math.max(res,dp[i][j]);
            }
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(dp[i][j]==0){
                    continue;
                }
                if(dp[i-1][j-1]!=0){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                }else{
                    dp[i][j]=1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }

        return res*res;
    }
}
