/**
 * Copyright (C), 2018-2019,
 * FileName: L_494_目标和
 * Author:   Administrator
 * Date:     2019/8/17 14:55
 * Description:
 */
package 动态规划;

public class L_494_目标和 {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }



    public static int  findTargetSumWays(int[] nums, int S) {
        return findTargetSon(nums,S,nums.length-1);
    }

    public static int findTargetSon(int[] nums,int S,int i){
        if(i==0){
            return (nums[i]==S?1:0) + (nums[i]==-S?1:0);
        }
        return findTargetSon(nums,S+nums[i],i-1)+findTargetSon(nums,S-nums[i],i-1);
    }
}