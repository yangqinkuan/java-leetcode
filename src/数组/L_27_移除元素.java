/**
 * Copyright (C), 2018-2019, FileName: L_27_移除元素 Author:   Administrator Date:     2019/9/1 8:02 Description:
 */
package 数组;


/**
 * 采用选择排序的思想，保存一个值不为target的下标指针
 */

public class L_27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        for(int i=0;i<1;i++){
            new Pthread().start();
        }
    }

    static class Pthread extends Thread{
        long i = 0;
        @Override
        public void run() {
            while (true){
                i = i+1;
                System.out.println(i);
            }

        }
    }

}