/**
 * FileName: L_14_最长公共前缀
 * Author:   yangqinkuan
 * Date:     2019-8-28 16:39
 * Description:
 */

package 字符串;

public class L_14_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int minlen = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minlen = Math.min(minlen,strs[i].length());
        }
        for(int i=0;i<minlen;i++){
            char c = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(c!=strs[i].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,minlen+1);
    }
}
