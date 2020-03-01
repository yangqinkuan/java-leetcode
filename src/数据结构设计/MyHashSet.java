package 数据结构设计;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;



//==========================


class MyHashSet {
    MyEntry[] table;
    int capacity;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.capacity = 8;
        table = new MyEntry[this.capacity];
    }

    public void add(int key) {
        int i = key%this.capacity;
        if(table[i]==null){
            table[i] = new MyEntry(key,0,null,key);
        }else{
            MyEntry node = table[i];
            while(node!=null){
                if(node.hash==key) return;
                node = node.next;
            }

            MyEntry entry = new MyEntry(key,0,null,key);
            entry.next = table[i];
            table[i] = entry;

        }
    }

    public void remove(int key) {
        int i = key%this.capacity;
        if(table[i]==null) return;
        if(table[i].hash==key) {
            table[i] = table[i].next;
            return;
        }
        MyEntry node = table[i];
        while(node.next!=null){
            if(node.next.hash==key){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = key%this.capacity;
        MyEntry node = table[i];
        while (node!=null){
            if(node.hash==key) return true;
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.contains(1);
        set.contains(3);
        set.add(2);

        set.contains(2);
        set.remove(2);
        System.out.println(set.contains(2));
    }


}
