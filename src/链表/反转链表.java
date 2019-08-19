/**
 * Copyright (C), 2018-2019,
 * FileName: 反转链表
 * Author:   Administrator
 * Date:     2019/8/18 20:03
 * Description:
 */
package 链表;

import commom.ListNode;

public class 反转链表 {
    //反转链表递归实现   1-2-3-4-5  1-2-3 5-4   1-2 5-4-3- ............
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    //反转链表非递归实现
    public ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

}