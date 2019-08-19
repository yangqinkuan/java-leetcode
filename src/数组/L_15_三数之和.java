/**
 * FileName: L_15_三数之和
 * Author:   yangqinkuan
 * Date:     2019-8-19 18:00
 * Description:
 */

package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L_15_三数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i>1&&nums[i]==nums[i-1]){
                continue;
            }
            List<Integer> list = new ArrayList<>();
            int left = i+1;
            int rignt = nums.length-1;
            while(left<rignt){
                if(nums[i]+nums[left]+nums[rignt]==0){
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[rignt]);
                    res.add(list);
                    break;
                }else if(nums[i]+nums[left]+nums[rignt]>0){
                    rignt--;
                }else {
                    left++;
                }
            }
        }



        return res;
    }
}
