package 数据结构设计;

public class MyEntry {
    int key;
    int value;
    MyEntry next;
    int hash;
    public MyEntry(int k,int v,MyEntry next,int hash){
        this.key = k;
        this.value = v;
        this.next = next;
        this.hash = hash;
    }

}
