/**
 * Copyright (C), 2018-2019,
 * FileName: L_169_求众数
 * Author:   Administrator
 * Date:     2019/8/18 2:14
 * Description:
 */
package 数组;

public class L_169_求众数 {
    //投票中和算法 应为众数比一般都多
    public int majorityElement(int[] nums) {
        int count = 1;
        int num = nums[0];
        for(int i=1;i<nums.length;i++){
            if(count==0){
                num = nums[i];
            }
            count+= nums[i]==num?1:-1;

        }
        return num;
    }
}