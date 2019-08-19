/**
 * FileName: L_315_计算右侧小于当前元素的个数
 * Author:   yangqinkuan
 * Date:     2019-8-1 17:57
 * Description:
 */

package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_315_计算右侧小于当前元素的个数 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        int length = nums.length;
        int[] dp = new int[length];
        for(int i=length-1;i>=0;i--){
            for(int j=length-1;j>i;j--){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        for(int i=0;i<length;i++){
            resultList.add(dp[i]);
        }
        return resultList;
    }
}
