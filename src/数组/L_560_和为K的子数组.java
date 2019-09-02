/**
 * Copyright (C), 2018-2019, FileName: L_560_和为K的子数组 Author:   Administrator Date:     2019/9/2 22:45 Description:
 */
package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 解法，用sum记录累计和，并将和存入map,每遍历一个数字，将直至该数字的累计和减去k，然后再从map获取差值的数量，
 * 即得到，到当前数，连续和为目标数的个数。记住初始化累计和key为0，value值为1
 */
public class L_560_和为K的子数组 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,1};
        int k = 3;
        System.out.println(subarraySum(nums,k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            res += map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}