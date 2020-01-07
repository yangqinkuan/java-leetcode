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
        //System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
        int[] nums = new int[]{1};
        int target = 1;
        System.out.println(findright(nums,target));
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int left = findleft(nums,target);
        int right = findright(nums,target);
        return new int[]{-1,-1};
    }
    public static int findleft(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==nums[mid]){
                right=mid;
                if(left==right) break;
            } else if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left<=right?left:-1;
    }
    public static int findright(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==nums[mid]){
                left=mid;
                if(left==right) break;
                if(left+1==right){
                    if(target==nums[right]){
                        left=right;
                    }
                    break;
                }

            }else if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left<=right?left:-1;
    }




   /* //寻找左便节，不断向左边收缩
    public static int searchleft(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left]==target?left:-1;
    }
    // 寻找右边界，不断向右边收缩，为防止死循环int mid = left+(right-left)/2+1;,mid计算时+1
    public static int searchright(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2+1;
            if(nums[mid] == target){
                left = mid;
            }else if(nums[mid]<target){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return nums[right]==target?right:-1;
    }*/
}
