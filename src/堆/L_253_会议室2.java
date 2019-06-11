/**
 * FileName: L_253_会议室2
 * Author:   yangqinkuan
 * Date:     2019-6-11 9:54
 * Description:
 */

package 堆;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L_253_会议室2 {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int rooms = 0;
        for(int i=0; i<intervals.length; i++) {
            minHeap.offer(intervals[i].end);
            if (intervals[i].start < minHeap.peek()) {
                rooms ++;
            } else {
                minHeap.poll();
            }
        }
        return rooms;
    }
}


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}