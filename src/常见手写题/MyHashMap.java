package 常见手写题;

import java.util.Objects;

public class MyHashMap<K,V> {
    int modcount;
    transient MyEntry<K,V>[] table;
    private int size;
    public MyHashMap(int capacity) {
        this.table = new MyEntry[capacity];
    }

    public V put(K key,V value){
        int hash = hash(key);
        int index = hash%table.length;
        for(MyEntry<K,V> e=table[index];e!=null;e=e.next){
            Object k;
            if(e.hash==hash && ((k=e.key)==key||key.equals(k))){
                V oldValue = e.getValue();
                e.value = value;
                return oldValue;
            }
        }
        modcount++;
        addEntry(hash,key,value,index);
        return null;
    }

    public V get(K key){
        int hash = hash(key);
        int index = hash%table.length;
        for(MyEntry<K,V> e=table[index];e!=null;e=e.next){
            Object k;
            if(e.hash==hash&&((k=e.key)==key||key.equals(k))){
                return e.getValue();
            }
        }
        return null;
    }

    public V remove(K key){
        V oldValue = null;
        int hash = hash(key);
        int index = hash%table.length;
        if(table[index]==null) return null;
        MyEntry<K,V> first = table[index];
        if(first.hash==hash&&(first.key==key||first.key.equals(key))){
            table[index] = first.next;
        }
        for(MyEntry<K,V> e = table[index];e!=null;e=e.next){
            Object k = e.next.key;
            if(e.hash==hash&&(k==key||key.equals(k))){
                oldValue = e.next.getValue();
                e.next = e.next.next;
            }
        }
        return oldValue;
    }

    public void addEntry(int hash,K key,V value,int index){
        MyEntry<K,V> entry = new MyEntry<>(key,value,null,hash);
        entry.next = table[index];
        table[index] = entry;
    }


    public int hash(Object key){
        return key==null?0:key.hashCode();
    }

    static class MyEntry<K,V>{
        K key;
        V value;
        MyEntry<K,V> next;
        int hash;

        public MyEntry(K key, V value, MyEntry<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        public final K getKey(){
            return key;
        }

        public final V getValue(){
            return value;
        }

        public final V setValue(V newValue){
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o){
            if(!(o instanceof MyEntry)){
                return false;
            }
            MyEntry e = (MyEntry) o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if(k1==k2 || (k1!=null&&k1.equals(k2))){
                Object v1 = getValue();
                Object v2 = e.getValue();
                if(v1==v2||(v1!=null&&v1.equals(v2))) return true;
            }
            return false;
        }


        public final int hascode(){
            return Objects.hash(getKey())^Objects.hash(getValue());
        }

        public final String toString(){
            return getKey()+"="+getValue();
        }
    }


}

