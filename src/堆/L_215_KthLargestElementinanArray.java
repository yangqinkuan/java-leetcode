/**
 * Copyright (C), 2018-2019,
 * FileName: L_215_KthLargestElementinanArray
 * Author:   Administrator
 * Date:     2019/5/25 19:51
 * Description:
 */
package 堆;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class L_215_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(15,0.8f,false);
        linkedHashMap.get("aaa");
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num: nums) {
            if(queue.size()<k){
                queue.add(num);
            }else {
                if(queue.peek()<num){
                    queue.poll();
                    queue.add(num);
                }
            }
        }

        return queue.poll();
    }

    public int findKthLargest1(int[] nums, int k) {

        return 0;
    }

}