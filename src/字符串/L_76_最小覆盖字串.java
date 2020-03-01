package 字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L_76_最小覆盖字串 {

    public static void main(String[] args) {


        System.out.println(minWindow("ADOBECODEBANC",
                "ABC"));
    }

    public static String minWindow(String s, String t) {
        int res = s.length()+1;
        int match = 0;
        int start = 0;
        Map<Character,Integer> tmap = new HashMap<>();
        Map<Character,Integer> smap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            tmap.put(c,tmap.getOrDefault(c,0)+1);
            smap.put(c,0);
        }
        int left = 0;
        int right = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            if(tmap.get(c)!=null){
                smap.put(c,smap.get(c)+1);
                if(smap.get(c).compareTo(tmap.get(c))==0){
                    match++;
                }
                while (match==tmap.size()){
                    char c1 = s.charAt(left);
                    if(smap.get(c1)!=null) {
                        if (right - left + 1 < res) {
                            start = left;
                            res = right - left + 1;
                        }

                        if(smap.get(c1).compareTo(tmap.get(c1))==0) match--;
                        smap.put(c1,smap.get(c1)-1);
                    }
                    left++;


                }
            }
            right++;
        }
        return res==s.length()+1?"":s.substring(start,start+res);
    }

}

