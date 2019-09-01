/**
 * Copyright (C), 2018-2019,
 * FileName: L_31_下一个排列
 * Author:   Administrator
 * Date:     2019/8/21 22:20
 * Description:
 */
package 数组;

import java.util.Arrays;

public class L_31_下一个排列 {
    public void nextPermutation(int[] nums) {


    }

    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}