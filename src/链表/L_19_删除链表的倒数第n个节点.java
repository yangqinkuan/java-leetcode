/**
 * Copyright (C), 2018-2019,
 * FileName: L_19_删除链表的倒数第n个节点
 * Author:   Administrator
 * Date:     2019/8/21 21:50
 * Description:
 */
package 链表;

import commom.ListNode;

public class L_19_删除链表的倒数第n个节点 {


    //删除节点的建议采用一个辅助头节点，然后把删除节点下一个节点的值赋值到删除节点，node.next = node.next.next
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null){
            return head;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode left = tempHead;
        ListNode right = tempHead;

        while (n+1>0){
            right = right.next;
            n--;
        }
        while(right!=null){
            left = left.next;
            right = right.next;
        }
        if(left.next.next==null){
            left.next = null;
        }else {
            left.next.val = left.next.next.val;
            left.next.next = left.next.next.next;
        }
        return tempHead.next;
    }
}