package 数据结构设计;

public class MyHashMap {
    int capacity;
    MyEntry[] table;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.capacity = 100;
        table = new MyEntry[this.capacity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = key%this.capacity;
        if(table[i]==null){
            table[i] = new MyEntry(key,value,null,key);
        }else{
            MyEntry node = table[i];

            while(node!=null){
                if(node.hash==key){
                    node.value = value;
                    return;
                }
                node = node.next;
            }

            MyEntry entry = new MyEntry(key,value,null,key);
            entry.next = table[i];
            table[i] = entry;

        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = key%this.capacity;
        MyEntry node = table[i];
        while (node!=null){
            if(node.hash==key) return node.value;
            node = node.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
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
}
