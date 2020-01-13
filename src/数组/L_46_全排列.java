/**
 * FileName: L_46_全排列
 * Author:   yangqinkuan
 * Date:     2019-12-27 12:15
 * Description:
 */

package 数组;

import java.util.ArrayList;
import java.util.List;

public class L_46_全排列 {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length!=0) digui(nums,0);

        return result;
    }

    public void digui(int[] nums,int j){
        if(j==nums.length-1){
            List<Integer> list = new ArrayList<Integer>(nums.length);
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        for(int i=j;i<nums.length;i++){
            swap(nums,j,i);
            digui(nums,j+1);
            swap(nums,j,i);
        }
    }


    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
