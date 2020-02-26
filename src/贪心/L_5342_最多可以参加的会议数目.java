package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 这是一道典型的扫描算法题。由于每个时间点最多参加一个会议，我们可以从1开始遍历所有时间。
 *
 * 对于每一个时间点，所有在当前时间及之前时间开始，并且在当前时间还未结束的会议都是可参加的。显然，在所有可参加的会议中，选择结束时间最早的会议是最优的，因为其他会议还有更多的机会可以去参加。
 *
 * 怎样动态获得当前结束时间最早的会议呢？我们可以使用一个小根堆记录所有当前可参加会议的结束时间。在每一个时间点，我们首先将当前时间点开始的会议加入小根堆，再把当前已经结束的会议移除出小根堆（因为已经无法参加了），然后从剩下的会议中选择一个结束时间最早的去参加。
 *
 * 为了快速获得当前时间点开始的会议，我们以O(N)O(N)时间预处理得到每个时间点开始的会议的序号。
 *
 * 算法总的时间复杂度为O(T\log N)O(TlogN)（这里的TT为时间范围）。
 *
 */
public class L_5342_最多可以参加的会议数目 {
    public int maxEvents(int[][] events) {

        Arrays.sort(events,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //当前时间线
        int day = 0;
        //遍历数组下标
        int index = 0;
        int n = events.length;
        int res = 0;

        while (index<n||queue.size()!=0){
            if(queue.size()==0){
                day = events[index][0];
                queue.add(events[index][1]);
                index++;
            }
            while (index<n&&events[index][0]<=day){
                queue.add(events[index][1]);
                index++;
            }
            if(queue.peek()>=day){
                day++;
                res++;
            }
            queue.poll();
        }

        return res;

    }

}
/**
 *
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 *
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 *
 * 请你返回你可以参加的 最大 会议数目。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 * 示例 2：
 *
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 * 示例 3：
 *
 * 输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：events = [[1,100000]]
 * 输出：1
 * 示例 5：
 *
 * 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
 * 输出：7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */