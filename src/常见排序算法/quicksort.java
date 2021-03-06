package 常见排序算法;

import java.util.concurrent.Executors;

/**
 * FileName: quicksort
 * Author:   yangqinkuan
 * Date:     2019-6-5 8:56
 * Description:
 */

public class quicksort {


    public static int findKthLargest(int[] nums, int k) {
        int point = nums.length-k;
        sort(0,nums.length-1,nums,point);
        return nums[point];
    }
    public static void sort(int left,int right,int[] nums,int point){
        if(left>=right){
            return;
        }
        int temleft = left;
        int temright = right;
        int temp = nums[left];
        while(left<right){
            while(nums[right]>=temp && left<right){
                right--;
            }
            nums[left] = nums[right];
            while(nums[left]<=temp && left<right){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[right] = temp;
        if(right>point){
            sort(temleft,left-1,nums,point);
        }else if(right<point){
            sort(left+1,temright,nums,point);
        }


    }

    public static void main(String[] args) {
        Executors.newFixedThreadPool(5);
        int m = 170;
        int n = 160;
        System.out.println(155*1.08);
    }
}
