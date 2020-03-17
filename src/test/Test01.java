package test;

import java.util.HashMap;
import java.util.Map;

public class Test01 {
    Map<Character,Character> mapping = new HashMap<>();
    int res = 0;

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Test01 test01 = new Test01();
        System.out.println("124".compareTo("124"));
        System.out.println(test01.strobogrammaticInRange("0","123"));
    }
    public int strobogrammaticInRange(String low, String high) {
        isStrobogrammatic();
        permutation(new StringBuilder(),low,high);
        permutation(new StringBuilder().append("0"),low,high);
        permutation(new StringBuilder().append("8"),low,high);
        permutation(new StringBuilder().append("1"),low,high);
        return res;
    }


    public void permutation(StringBuilder s,String low,String high){
        if(s.length()>high.length()){
            return;
        }
        if(s.length()>=low.length()){
            boolean flag = iscontain(s.toString(),low,high);
            if(flag&&(!(s.length()>1&&s.charAt(0)=='0'))){
                System.out.println(s);
                res++;
            }
        }
        for(Character c:mapping.keySet()){
            s.insert(0,c).append(mapping.get(c));
            permutation(s,low,high);
            s.deleteCharAt(0);
            s.deleteCharAt(s.length()-1);
        }
    }

    //判断是否在范围内
    public boolean iscontain(String str,String low,String high){
        if(str.length()<low.length()||str.length()>high.length()) return false;
        if(str.length()>low.length()&&str.length()<high.length()) return true;
        if(str.length()==low.length()&&str.compareTo(low)<0) return false;
        if(str.length()==high.length()&&str.compareTo(high)>0) return false;
        return true;
    }

    public void isStrobogrammatic() {
        mapping.put('6','9');
        mapping.put('9','6');
        mapping.put('1','1');
        mapping.put('0','0');
        mapping.put('8','8');
    }
}
