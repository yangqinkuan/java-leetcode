/**
 * FileName: L_26_删除排序数组中的重复项
 * Author:   yangqinkuan
 * Date:     2019-12-10 8:13
 * Description:
 */

package 数组;

public class L_26_删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int right = 1;
        int left = 0;
        while(right<nums.length){
            if(nums[left]==nums[right]){
                right++;
                continue;
            }
            swap(nums,left+1,right);
            left = left+1;
            right++;
        }
        return left;
    }
    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
