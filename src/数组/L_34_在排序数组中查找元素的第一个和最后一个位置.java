/**
 * FileName: L_34_在排序数组中查找元素的第一个和最后一个位置
 * Author:   yangqinkuan
 * Date:     2019-8-21 15:46
 * Description:
 */

package 数组;

import java.util.Arrays;

public class L_34_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{2,2},2)));
    }

    //采用二分将两边界的值锁定在两边的 两个数，   (不能锁定一个数，因为有些情况会死循环),然后再判断那个数符合编解
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int[] res = new int[2];
        int left = 0;
        int right = nums.length-1;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if(nums[left]==target){
            res[0] = left;
        }else {
            res[0] = right;
        }
        left = 0;
        right = nums.length-1;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else {
                left = mid;
            }
        }
        if(nums[right]==target){
            res[1] = right;
        }else {
            res[1] = left;
        }
        if(nums[res[0]]!=target){
            return new int[]{-1,-1};
        }
        return res;
    }
}
