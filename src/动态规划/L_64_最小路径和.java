/**
 * FileName: L_64_最小路径和
 * Author:   yangqinkuan
 * Date:     2019-8-15 14:19
 * Description:
 */

package 动态规划;

public class L_64_最小路径和 {
    public int minPathSum(int[][] grid) {
        if(grid.length==0){
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length-1];

    }
}
