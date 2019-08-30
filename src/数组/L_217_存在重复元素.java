/**
 * FileName: L_217_存在重复元素
 * Author:   yangqinkuan
 * Date:     2019-8-28 16:15
 * Description:
 */

package 数组;

import java.util.HashSet;
import java.util.Set;

public class L_217_存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x:nums){
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
