package 字符串;

public class L_159_至多包含两个不同的字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        int[] table = new int[126];
        int count = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            if(table[c-'0']==0){
                count++;
                while(count>2&&left<right){
                    table[s.charAt(left)-'0']--;
                    if(table[s.charAt(left)-'0']==0){
                        count--;
                    }
                    left++;
                }
            }
            res = Math.max(res,right-left+1);
            table[c-'0']++;
            right++;
        }
        return res;
    }
}
