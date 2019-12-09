/**
 * FileName: L_287_寻找重复数
 * Author:   yangqinkuan
 * Date:     2019-12-5 17:50
 * Description:
 */

package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class L_287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int result = (nums.length)*(nums.length-1)/2;

        return sum-result;
    }

    public static void main(String[] args) {


        }
    }


