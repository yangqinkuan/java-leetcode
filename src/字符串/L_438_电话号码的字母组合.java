/**
 * Copyright (C), 2018-2019,
 * FileName: L_438_电话号码的字母组合
 * Author:   Administrator
 * Date:     2019/8/21 20:33
 * Description:
 */
package 字符串;

import java.util.*;

public class L_438_电话号码的字母组合 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(letterCombinations("23354354343432"));
        System.out.println(System.currentTimeMillis()-start);
    }

    //采用 两两归并 发现冗余，效率不如广度优先遍历
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        Map<Integer,String[]> baseMap = new HashMap<>();
        baseMap.put(2,new String[]{"a","b","c"});
        baseMap.put(3,new String[]{"d","e","f"});
        baseMap.put(4,new String[]{"g","h","i"});
        baseMap.put(5,new String[]{"j","k","l"});
        baseMap.put(6,new String[]{"m","n","o"});
        baseMap.put(7,new String[]{"p","q","r","s"});
        baseMap.put(8,new String[]{"t","u","v"});
        baseMap.put(9,new String[]{"w","x","y","z"});
        int len = 0;
        LinkedList<String[]> strList = new LinkedList<>();
        for(int i=0;i<digits.length();i++){
            if(digits.charAt(i)!='0'){
                strList.add(baseMap.get(digits.charAt(i)-'0'));
                len++;
            }
        }





        while(len>1){
            while(len>1){
                strList.add(merge(strList.poll(),strList.poll()));
                len = len-2;
            }
            if(len==1){
                strList.add(strList.pop());
            }
            len = strList.size();
        }
        String[] resArr = strList.pop();
        for (String s: resArr) {
            res.add(s);
        }
        return res;
    }

    public static String[] merge(String[] s1,String[] s2){
        String[] res = new String[s1.length*s2.length];
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s2.length;j++){
                res[s2.length*i+j] = s1[i]+s2[j];
            }
        }
        return res;
    }



    //该方法采用广度优先遍历，
    public static List<String> letterCombinations1(String digits) {

        List<String>list=new ArrayList<>();
        String []s=new String[digits.length()];
        int M=digits.length();
        if(s.length==0){
            return list;
        }
        for(int i=0;i<digits.length();i++){
            switch (digits.charAt(i)){
                case '2':s[i]="abc";break;
                case '3':s[i]="def";break;
                case '4':s[i]="ghi";break;
                case '5':s[i]="jkl";break;
                case '6':s[i]="mno";break;
                case '7':s[i]="pqrs";break;
                case '8':s[i]="tuv";break;
                case '9':s[i]="wxyz";break;
            }
        }
        list=getStringWithFor(s,0,list,"");
        return list;
    }

    private static List<String> getStringWithFor(String []s,int i,List<String> list,String stemp) {

        if(i<s.length-1){
            for(int j=0;j<s[i].length();j++){
                list=getStringWithFor(s,i+1,list,stemp+s[i].charAt(j));
            }
        } else {
            for(int j=0;j<s[i].length();j++){
                list.add(stemp+s[i].charAt(j));
            }
        }

        return list;
    }

    public static List<String> letterCombinations3(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;

    }
}