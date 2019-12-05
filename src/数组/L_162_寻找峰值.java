/**
 * FileName: L_162_寻找峰值
 * Author:   yangqinkuan
 * Date:     2019-11-18 20:29
 * Description:
 */

package 数组;

public class L_162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        for(;left<right;){
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[mid+1]){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        return 0;
    }

}
