/**
 * FileName: L_350_两个数组的交集
 * Author:   yangqinkuan
 * Date:     2019-7-3 9:55
 * Description:
 */

package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_350_两个数组的交集 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> array = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i=0;
        int j=0;
        while (i<len1&&j<len2){
            if(nums1[i]==nums2[j]){
                array.add(nums1[i]);
                    i++;
                    j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        int[] nums = new int[array.size()];
        for(int m=0;m<array.size();m++){
            nums[m] = array.get(m);
        }

        return nums;
    }
}
