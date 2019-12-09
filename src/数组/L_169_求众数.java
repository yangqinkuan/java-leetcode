/**
 * Copyright (C), 2018-2019,
 * FileName: L_169_求众数
 * Author:   Administrator
 * Date:     2019/8/18 2:14
 * Description:
 */
package 数组;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 解法，根据题目给出的性质，有一个数的和大于其它数的总和，所以可以采用投票算法，众数投赞同票，其它数投反对票
 */
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