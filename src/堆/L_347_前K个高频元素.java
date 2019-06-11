/**
 * FileName: L_347_前K个高频元素
 * Author:   yangqinkuan
 * Date:     2019-6-11 11:27
 * Description:
 */

package 堆;

import java.util.*;

public class L_347_前K个高频元素 {
    public List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer num: nums) {
            Integer count = map.get(num)==null?0:map.get(num);
            map.put(num,count+1);
        }
        Queue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,  Integer o2) {
                return map.get(o1)>map.get(o2)?1:-1;
            }
        });
        for (int key:map.keySet()){
            if(queue.size()<k){
                queue.add(key);
            }else if(map.get(key)>map.get(queue.peek())){
                queue.poll();
                queue.add(key);

            }
        }
        List<Integer> res = new ArrayList<>();

        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args) {

    }
}

