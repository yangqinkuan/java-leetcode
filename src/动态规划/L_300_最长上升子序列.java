/**
 * FileName: L_300_最长上升子序列
 * Author:   yangqinkuan
 * Date:     2019-8-1 15:24
 * Description:
 */

package 动态规划;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解题思路:当遇到众多不确定的问题时，可以才用枚举定边界分析法
 */


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
