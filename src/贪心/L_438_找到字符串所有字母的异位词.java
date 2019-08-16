/**
 * FileName: L_438_找到字符串所有字母的异位词
 * Author:   yangqinkuan
 * Date:     2019-8-13 16:14
 * Description:
 */

package 贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L_438_找到字符串所有字母的异位词 {

    public static void main(String[] args) {
        //System.out.println(Collections.t);findAnagrams("cbaebabacd","abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s==null||s.equals("")){
            return result;
        }
        int[] bucket1 = new int[26];
        char[] charArrayP = p.toCharArray();
        for(int i=0;i<charArrayP.length;i++){
            bucket1[charArrayP[i]-'a']=1;
        }
        int[] bucket2 = new int[26];
        char[] charArrayS = s.toCharArray();
        for(int i=0;i<charArrayP.length-1;i++){
            bucket2[charArrayS[i]-'a'] +=1;
        }

        for(int i=charArrayP.length-1;i<charArrayS.length;i++){
            bucket2[charArrayS[i]-'a']+=1;
            if(isYiwei(charArrayS,i,bucket1,bucket2)){
                result.add(i-2);
            }
            bucket2[charArrayS[i-2]-'a'] -=1;
        }
        return result;
    }

    public static boolean isYiwei(char[] charArrayS,int i,int[] bucket1,int[] bucket2){
        if(bucket1[charArrayS[i-1]-'a']!=bucket2[charArrayS[i-1]-'a']){
            return false;
        }
        if(bucket1[charArrayS[i-2]-'a']!=bucket2[charArrayS[i-2]-'a']){
            return false;
        }
        if(bucket1[charArrayS[i-3]-'a']!=bucket2[charArrayS[i-3]-'a']){
            return false;
        }

        return true;
    }

}
