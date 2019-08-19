/**
 * FileName: L_53_最大子序列和
 * Author:   yangqinkuan
 * Date:     2019-8-15 14:18
 * Description:
 */

package 动态规划;

public class L_53_最大子序列和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
