package 数论;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 *
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class L_1071_字符串的最大公因子 {

    public static void main(String[] args) {
        L_1071_字符串的最大公因子 test = new L_1071_字符串的最大公因子();
        System.out.println(test.gcd(7,8));
    }
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if(!(str1+str2).equals(str2+str1)) return "";
        int gcd = len1>len2?gcd(len1,len2):gcd(len2,len1);
        String T = str1.substring(0,gcd);
        return T;
    }

    public int gcd(int max,int min){
        return max%min==0?min:gcd(min,max%min);
    }
}
