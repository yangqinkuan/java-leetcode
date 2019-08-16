/**
 * Copyright (C), 2018-2019,
 * FileName: L_23_MergekSortedList
 * Author:   Administrator
 * Date:     2019/5/25 18:47
 * Description:
 */
package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class L_23_MergekSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (ListNode list: lists) {
            while(list!=null){
                queue.add(list.val);
                list = list.next;
            }
        }
        ListNode head = null;
        ListNode cur;
        if(queue.size()!=0){
            cur = head = new ListNode(queue.poll());
            while(queue.size()!=0){
                cur.next = new ListNode(queue.poll());
                cur = cur.next;
            }
        }
        return head;
    }


    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null)
                queue.add(p.next);
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int kuadu = 1;

        return null;
    }
}