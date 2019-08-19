/**
 * Copyright (C), 2018-2019,
 * FileName: L_160_相交链表
 * Author:   Administrator
 * Date:     2019/8/18 1:49
 * Description:
 */
package 链表;

import commom.ListNode;

public class L_160_相交链表 {
    //基本操作
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1!=null){
            len1++;
            p1 = p1.next;
        }
        while(p2!=null){
            len2++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if(len1>len2){
            while(len1>len2){
                p1 = p1.next;
                len1--;
            }
        }else{
            while(len2>len1){
                p2 = p2.next;
                len2--;
            }

        }
        while(len1>0){
            if(p1==p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;

            len1--;
        }
        return null;
    }

    //骚操作，让两个指针都跑一边链表A和链表B，如果链表相交，到达共同点的时间是相同的，如果链表不相交，同时为null;返回结果即可
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}