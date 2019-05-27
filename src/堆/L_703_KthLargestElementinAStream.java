/**
 * FileName: L_703_KthLargestElementinAStream
 * Author:   yangqinkuan
 * Date:     2019-5-20 19:32
 * Description:
 */

package 堆;

import java.util.PriorityQueue;

/**
 * 小顶堆实现
 */
public class L_703_KthLargestElementinAStream {
    final PriorityQueue<Integer> q ;
    final int k;
    public L_703_KthLargestElementinAStream(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for(int i: nums) {
            add(i);
        }
    }

    public int add(int val) {
        if(q.size() < k) {
            q.offer(val);

        } else if(q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
