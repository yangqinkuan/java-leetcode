package 数组;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 *
 * 示例：
 *
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 *      [-2,0,1]
 *      [-2,0,3]
 */

public class L_259_较小的三数之和 {

    public static void main(String[] args) {
        L_259_较小的三数之和 test = new L_259_较小的三数之和();
        test.threeSumSmaller(new int[]{-2,0,1,3},2);
    }


    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=2;i<nums.length;i++){
            int left = 0;
            int right = i-1;
            while(left<right){
                int sum = nums[left]+nums[right]+nums[i];
                if(sum==target){
                    res += right-left-1;
                    left++;
                }else if(sum>target){
                    right--;
                }else{
                    res += right-left;
                    left++;

                }
            }
        }
        return res;
    }
}
