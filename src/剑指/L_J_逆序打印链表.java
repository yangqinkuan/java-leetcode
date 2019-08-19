/**
 * FileName: L_J_逆序打印链表
 * Author:   yangqinkuan
 * Date:     2019-7-29 11:51
 * Description:
 */

package 剑指;

import commom.ListNode;

import java.util.ArrayList;
import java.util.List;

public class L_J_逆序打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        addList(list,listNode);
        return list;
    }
    public void addList(ArrayList<Integer> list,ListNode listNode){
        if(listNode!=null){
            addList(list,listNode.next);
            list.add(listNode.val);
        }
    }
}
