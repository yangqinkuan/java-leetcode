/**
 * Copyright (C), 2018-2019,
 * FileName: L_438_无重复字符的最长字串
 * Author:   Administrator
 * Date:     2019/8/19 21:37
 * Description:
 */
package 字符串;

import java.util.HashMap;
import java.util.Map;

public class L_438_无重复字符的最长字串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"
        ));
    }

    //普通滑动窗口，两个指针，先用右指针往右遍历，找到重复的停止，算最大值，左指针往右移，知道删除重复的第一个字母，然后继续前面步骤
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int max = 1;
        int left = 0;
        Map<Character,Integer> win = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!win.containsKey(s.charAt(i))){
                win.put(s.charAt(i),1);
                continue;
            }
            max = Math.max(max,i-left);
            while (win.containsKey(s.charAt(i))){
                win.remove(s.charAt(left));
                left++;
            }
            win.put(s.charAt(i),1);
        }
        max = Math.max(max,s.length()-left);
        return max;
    }
    //优化的滑动窗口，用value记录某个字母最新出现的地方   需考虑窗口左端的位置问题
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}