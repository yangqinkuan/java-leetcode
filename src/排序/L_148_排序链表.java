/**
 * FileName: L_148_排序链表
 * Author:   yangqinkuan
 * Date:     2019-7-23 17:33
 * Description:
 */

package 排序;

import commom.ListNode;

import java.util.List;

public class L_148_排序链表 {
    public static ListNode sortList(ListNode head) {
        if (head == null) return head;
        ListNode countNode = head;
        //计算出链表的长度
        int count = 0;
        while (countNode != null) {
            count++;
            countNode = countNode.next;
        }
        return sortList(head, count);
    }
    /**
     * 排序链表
     * @param head
     * @param count
     * @return
     */
    private static ListNode sortList(ListNode head, int count) {
        //递归结束条件
        if (count <= 1) return head;
        ListNode leftEnd = head;
        for (int i = 0; i < count / 2-1; i++) {
            leftEnd = leftEnd.next;
        }
        ListNode rightStart = leftEnd.next;
        //断链，如果不断链，各种判断让你死去活来
        leftEnd.next = null;
        //合并两个已经排完序的链表
        //第二个链表的长度为count - count / 2，不能直接是count / 2，奇数计算会错误
        return merge(
                sortList(head, count / 2),
                sortList(rightStart, count - count / 2)
        );
    }


    /**
     * 合并有序的链,使用递归更加简洁和易懂，每次只比较两个链表的链头
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1.next = merge(l1.next, l2);
        } else {
            head = l2;
            l2.next = merge(l1, l2.next);
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head;
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        head=n1;
        ListNode node = sortList(head);
        while (node!=null){
            System.out.print(node.val);
            node=node.next;
        }

    }
}
