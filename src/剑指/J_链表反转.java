/**
 * FileName: J_链表反转
 * Author:   yangqinkuan
 * Date:     2019-8-5 14:07
 * Description:
 */

package 剑指;

import commom.ListNode;

import java.util.List;

public class J_链表反转 {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode temp = head.next;
        ListNode newHead = ReverseList(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode ReverseList1(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;

        }
        return pre;
    }
}
