/**
 * FileName: L_300_最长上升子序列
 * Author:   yangqinkuan
 * Date:     2019-8-1 15:24
 * Description:
 */

package 动态规划;

import java.util.Arrays;

public class L_300_最长上升子序列 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==0){
            return 0;
        }
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int res = dp[0];
        for(int m=0;m<nums.length;m++){
            res = Math.max(res,dp[m]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.print(lengthOfLIS(nums));
    }
}
