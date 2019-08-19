/**
 * FileName: L_239_滑动窗口最大值
 * Author:   yangqinkuan
 * Date:     2019-6-10 11:48
 * Description:
 */

package 堆;

import java.util.LinkedList;
import java.util.Queue;

public class L_239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2){
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList();
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.add(i);
            if(queue.peek()<=i-k){
                queue.poll();
            }
            if(i-k+1>=0){
                result[i-k+1] = nums[queue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
    }
}
