/**
 * FileName: L_496_NextGreaterElement1
 * Author:   yangqinkuan
 * Date:     2019-5-20 17:26
 * Description:
 */

package 栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * 下一个更大元素
 */
public class L_496_NextGreaterElement1 {
    /**
     * 栈解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();

        int[] result = new int[nums1.length];

        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek()<num){
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for(int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);

        return result;
    }

}
