/**
 * FileName: 动态规划
 * Author:   yangqinkuan
 * Date:     2019-8-1 15:23
 * Description:
 */

public class 动态规划 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i] =1;
        }
        int max = 1;
        for(int i=1;i<nums.length;i++){
            int index = firstMin(nums,i);
            if(index!=-1){
                dp[i] = dp[index]+1;
                max = Math.max(max,dp[i]);
            }
            ;
        }
        return max;
    }

    public static int firstMin(int[] nums,int index){
        for(int i=index-1;i>=0;i--){
            if(nums[index]>=nums[i]){
                return i;
            }
        }
        return -1;
    }
}
