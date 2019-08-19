/**
 * Copyright (C), 2018-2019,
 * FileName: L_136_只出现一次的数字
 * Author:   Administrator
 * Date:     2019/8/18 1:10
 * Description:
 */
package 数组;

public class L_136_只出现一次的数字 {
    /**
     * 相同的数异或为0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i=0;i<nums.length;i++){
            num ^= nums[i];
        }
        return num;
    }
}