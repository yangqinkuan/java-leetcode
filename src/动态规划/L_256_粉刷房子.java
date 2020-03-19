package 动态规划;

import java.util.Arrays;

public class L_256_粉刷房子 {


    public static void main(String[] args) {

    }

    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length+1][3];
        for(int[] nums:dp){
            Arrays.fill(nums,Integer.MAX_VALUE);
        }
        for(int j=0;j<costs[0].length;j++){
            dp[0][j] = 0;
        }
        for(int i=0;i<costs.length;i++){
            dp[i+1][0] = Math.min(Math.min(dp[i][1],dp[i][2])+costs[i][0],dp[i+1][0]);
            dp[i+1][1] = Math.min(Math.min(dp[i][0],dp[i][2])+costs[i][0],dp[i+1][0]);
            dp[i+1][2] = Math.min(Math.min(dp[i][1],dp[i][0])+costs[i][0],dp[i+1][0]);
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            if(dp[costs.length][i]<res) res = dp[costs.length][i];
        }
        return res;
    }
}
