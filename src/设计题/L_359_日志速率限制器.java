package 设计题;

import java.util.*;

public class L_359_日志速率限制器 {

    /** Initialize your data structure here. */
    Map<Integer,List<String>> bucket;
    Set<String> set;
    public L_359_日志速率限制器() {
        bucket = new HashMap<>();
        set = new HashSet<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        for(Integer time:bucket.keySet()){
            if(time <= (timestamp-10)){
                List<String> list = bucket.get(time);
                for(String s:list){
                    set.remove(s);
                }
                bucket.remove(time);
            }
        }
        if(!set.contains(message)){
            List<String> lists = bucket.get(timestamp);
            if(lists==null){
                lists = new ArrayList<>();
            }
            lists.add(message);
            bucket.put(timestamp,lists);
            set.add(message);
            return true;
        }
        return false;
    }
}
