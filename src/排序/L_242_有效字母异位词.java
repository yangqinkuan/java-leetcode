/**
 * FileName: L_242_有效字母异位词
 * Author:   yangqinkuan
 * Date:     2019-7-3 9:45
 * Description:
 */

package 排序;

public class L_242_有效字母异位词 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']++;
        }
        for (int count:counter){
            if(count!=0){
                return false;
            }
        }

        return false;
    }
}
