package 字符串;

public class L_125_验证回文串 {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        int left=0;
        int right = s.length()-1;
        while(left<right){
            while(!ishefa(s.charAt(left))){
                left++;
            }
            while(!ishefa(s.charAt(right))){
                right--;
            }
            if(!isequal(s.charAt(left),s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
    public static boolean ishefa(char c){
        if(c>='0'&&c<='9') return true;
        if(c>='a'&&c<='z') return true;
        if(c>='A'&&c<='Z') return true;
        return false;
    }
    public static boolean isequal(char c1,char c2){
        int a = 0;
        a = c1>='a'?c1-'a':c1-'A';
        int b = 0;
        b = c2>='a'?c2-'a':c2-'A';
        return a==b;
    }
}
