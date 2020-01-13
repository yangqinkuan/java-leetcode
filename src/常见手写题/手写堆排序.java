/**
 * FileName: 手写堆排序
 * Author:   yangqinkuan
 * Date:     2019-12-23 18:02
 * Description:
 */

package 常见手写题;

import java.util.Arrays;

public class 手写堆排序 {


    public static void main(String[] args) {
        int[] nums = new int[]{5,8,6,1,48,9,6,7};
        oneSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void oneSort(int[] nums){

        for(int i=nums.length-1;i>=0;i--){
            for(int j=i/2-1;j>=0;j--){
                buildHeap(nums,j);
                swap(nums,0,i);
            }

        }


    }
    public static void buildHeap(int[] nums,int k){
        int left = 2*k+1;
        int right = left+1;
        if(right<nums.length&&nums[right]>nums[k]) swap(nums,right,k);
        if(nums[left]>nums[k]) swap(nums,left,k);
    }
    public  static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
