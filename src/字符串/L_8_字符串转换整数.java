package 字符串;

public class L_8_字符串转换整数 {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }

    public static int myAtoi(String str) {
        int  p = 0;
        boolean flag = false;
        boolean fushu = false;
        long res = 0;
        while(p<str.length()&&!flag){
            char c = str.charAt(p);
            if(c==' '){
                p++;
                continue;
            }
            if(c=='-'){
                flag = true;
                fushu = true;
                p++;
                continue;
            }
            if(c=='+'){
                flag = true;
                p++;
                continue;
            }
            if(c>='0'&&c<='9'){
                flag = true;
                continue;
            }
            return 0;
        }
        while(p<str.length()){
            char c = str.charAt(p);
            if(c>='0'&&c<='9'){
                res = c-'0'+res*10;
                p++;
                if(!fushu&&res>2147483647l){
                    return Integer.MAX_VALUE;
                }
                if(fushu&&res>2147483648l){
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        res = fushu?res*-1l:res;
        return (int)res;
    }
}
