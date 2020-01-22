package 字符串;

import java.util.HashMap;
import java.util.Map;

public class L_28_字符串 {
    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(function(haystack,needle));
    }

    /**
     * sumday算法
     * @param s1
     * @param s2
     * @return
     */
    public static int function(String s1,String s2){
        if(s2.equals("")) return -1;
        Map<Character,Integer> map = new HashMap<>();
        for(int m=0;m<s2.length();m++){
            map.put(s2.charAt(m),m);
        }
        int idx = 0;
        while(idx<s1.length()-s2.length()+1){
            for(int i=0;i<s2.length();i++){
                if(s1.charAt(idx+i)!=s2.charAt(i)){
                    if(idx+s2.length()>=s1.length()) return -1;
                    if(map.get(s1.charAt(idx+s2.length()))==null){
                        idx = idx+s2.length()+1;
                        break;
                    }else{
                        idx = idx+s2.length()-map.get(s1.charAt(idx+s2.length()));
                        break;
                    }
                }
                if(i==s2.length()-1) return idx;
            }

        }
        return -1;
    }

    static int sunday(char[] total,char[] part){
        int tSize = total.length;
        int pSize = part.length;
        int[] move = new int[126];
        //主串参与匹配最末位字符移动到该位需要移动的位数
        for (int i= 0;i<126;i++){
            move[i] = pSize+1;
        }

        for (int i = 0;i<pSize;i++){
            move[part[i]] = pSize-i;
        }

        int s = 0;//模式串头部在字符串位置

        int j;//模式串已经匹配了的长度

        while(s<=tSize-pSize){//到达末尾之前
            j = 0;
            while(total[s+j]==part[j]){
                j++;
                if (j>=pSize){
                    return s;
                }
            }
            s+=move[total[s+pSize]];
        }
        return -1;
    }
}
