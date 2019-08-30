/**
 * FileName: L_237_删除链表中的节点
 * Author:   yangqinkuan
 * Date:     2019-8-28 16:36
 * Description:
 */

package 链表;

import commom.ListNode;

public class L_237_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        if(node==null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
