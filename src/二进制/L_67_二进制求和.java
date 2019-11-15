/**
 * FileName: L_67_二进制求和
 * Author:   yangqinkuan
 * Date:     2019-9-25 9:54
 * Description:
 */

package 二进制;

public class L_67_二进制求和 {

    public static void main(String[] args) {
        addBinary("1010","1011");
    }

    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length()-1;
        int j = b.length()-1;
        int k = 0;
        while(i>=0||j>=0){
            if(i<0){
                int tempb = b.charAt(j)-'0';
                sb.append(k^tempb);
                k = tempb&k;
                j--;
            }else if (j<0) {
                int tempa = a.charAt(i)-'0';
                sb.append(k^tempa);
                k = tempa&k;
                i--;
            }else {
                int tempa = a.charAt(i)-'0';
                int tempb = b.charAt(j)-'0';    
                sb.append(tempa^tempb^k);
                if((tempa&tempb)==1||((tempa|tempb)==1&&k==1)){
                    k=1;
                }else {
                    k=0;
                }
                i--;
                j--;
            }

        }
        if(k==1) sb.append(k);
        sb.reverse();
        System.out.println(sb);
        return sb.toString();
    }
    public String addBinary1(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();

    }
}
