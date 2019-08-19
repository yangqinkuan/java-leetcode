/**
 * Copyright (C), 2018-2019,
 * FileName: L_21_合并两个有序链表
 * Author:   Administrator
 * Date:     2019/8/17 23:39
 * Description:
 */
package 链表;

import commom.ListNode;

public class L_21_合并两个有序链表 {


    /**
     * 非递归写法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1!=null||l2!=null){
            if(l1==null){
                p.next=l2;
                break;
            }
            if(l2==null){
                p.next=l1;
                break;
            }
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        return head.next;

    }

    /**
     * 递归写法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }
}