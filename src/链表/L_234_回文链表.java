/**
 * Copyright (C), 2018-2019,
 * FileName: L_234_回文链表
 * Author:   Administrator
 * Date:     2019/8/18 21:48
 * Description:
 */
package 链表;

import commom.ListNode;

public class L_234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode node = head;
        while(node!=null){
            n += 1;
            node = node.next;
        }
        n = (n+1)/2;
        node = head;
        while(n>0){
            n--;
            node = node.next;
        }
        ListNode head1 = reverse(node);
        while(head!=null&&head1!=null){
            if(head.val!=head1.val){
                return false;
            }
            head = head.next;
            head1 = head1.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        ListNode node = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = node;
            node = head;
            head = next;
        }

        return node;

    }
}