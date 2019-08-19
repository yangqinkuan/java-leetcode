/**
 * Copyright (C), 2018-2019,
 * FileName: L_283_移动零
 * Author:   Administrator
 * Date:     2019/8/18 22:18
 * Description:
 */
package 数组;

public class L_283_移动零 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
    }

}