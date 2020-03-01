package 常见排序算法;

import java.util.Arrays;

/**
 * FileName: HeapSort
 * Author:   yangqinkuan
 * Date:     2019-7-31 10:36
 * Description:
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {5,6,8,1,2,9,10,3,7,4};
        for(int i=nums.length;i>0;i--){
            buildmaxheap(nums,i);
            swap(nums,0,i-1);
        }
        System.out.print(Arrays.toString(nums));;
    }
    public static void buildmaxheap(int[] nums,int length){
        for(int i=length/2-1;i>=0;i--){
            buildsonheap(nums,i,length);
        }
    }
    public static void buildsonheap(int[] nums,int index,int length){
        int left = index*2+1;
        int right = index*2+2;
        if(right<length&&nums[index]<nums[right]){
            swap(nums,index,right);
        }
        if(left<length&&nums[index]<nums[left]){
            swap(nums,index,left);
        }

    }
    public static void swap(int[] nums,int m,int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }


}
