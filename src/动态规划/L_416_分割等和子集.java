/**
 * FileName: L_416_分割等和子集
 * Author:   yangqinkuan
 * Date:     2019-8-16 9:59
 * Description:
 */

package 动态规划;

public class L_416_分割等和子集 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5,5,3}));
    }


    /**
     *  01背包思路  从物品数量从前往后遍历，可以选择取或者不取，看最后使得价值是否位sum/2
     *   数的值大于 容量
     *   dp[i+1][j] = dp[i][j]
     *   数的值小于容量可以选择装或者不装
     *   dp[i+1][j] = dp[i][j]||dp[i][j-nums[i]];
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }
        if((sum&1)==1){
            return false;
        }
        sum = sum/2;
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        dp[0][0] = true;
        for(int i=0;i<=nums.length;i++){
            dp[i][0] = true;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=sum;j++){

                if(j<nums[i]){
                    dp[i+1][j] = dp[i][j];
                    continue;
                }
                dp[i+1][j] = dp[i][j]||dp[i][j-nums[i]];
            }
        }
        return dp[nums.length][sum];
    }

}
