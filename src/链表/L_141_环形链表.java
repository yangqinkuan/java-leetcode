/**
 * Copyright (C), 2018-2019,
 * FileName: L_141_环形链表
 * Author:   Administrator
 * Date:     2019/8/18 1:28
 * Description:
 */
package 链表;

import commom.ListNode;

import java.util.HashSet;
import java.util.Set;

public class L_141_环形链表 {
    //拙略写法
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while(p2!=null){
            if(p2.next==null||p2.next.next==null){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1==p2){
                return true;
            }
        }
        return false;
    }
    //优雅写法
   /* if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;*/
    //hash思路
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}