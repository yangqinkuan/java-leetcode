package test;

import 常见手写题.MyHashMap;

import java.util.*;
import java.util.concurrent.*;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        LinkedHashMap linkedHashMap = new LinkedHashMap(3,0.75f,true);

        MyHashMap<String,String> myHashMap = new MyHashMap(10);
        myHashMap.put("杨沁宽","帅哥");
        myHashMap.put("傻逼","丑逼");
        System.out.println(myHashMap.get("杨沁宽"));
        myHashMap.remove("杨沁宽");
        System.out.println(myHashMap.get("杨沁宽"));

        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println(set.ceiling(1));
    }


}
class User{
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }


}
