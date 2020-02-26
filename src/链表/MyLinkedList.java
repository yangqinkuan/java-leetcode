package 链表;


/**
 * 增加一个哨兵节点会更容易处理
 */


class MyLinkedList {
    ListNode lead;
    /** Initialize your data structure here. */

    public MyLinkedList() {
        lead = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode node = lead;
        while(index>=0&&node!=null){
            node = node.next;
            index--;
        }
        return node==null?-1:node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode n = new ListNode(val);
        n.next = lead.next;
        lead.next = n;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode n = new ListNode(val);
        ListNode node = lead;
        while(node.next!=null){
            node = node.next;
        }
        node.next = n;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode node = lead;
        while(index>0&&node!=null){
            node = node.next;
            index--;
        }
        if(node!=null){
            ListNode n = new ListNode(val);
            n.next = node.next;
            node.next = n;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode node = lead;

        while(index>0&&node!=null){
            node = node.next;
            index--;
        }
        if(node!=null&&node.next!=null){
            node.next = node.next.next;
        }

    }


}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int value){
        this.val = value;
        this.next = null;
    }
}