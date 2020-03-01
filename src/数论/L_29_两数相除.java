package 数论;

public class L_29_两数相除 {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648,1));
    }

    public static int divide(int dividend1, int divisor1) {
        long dividend = dividend1;
        long divisor = divisor1;
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
        boolean zheng = false;;
        if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)){
            zheng = true;
        }
        if(dividend<0) dividend = 0-dividend;
        if(divisor<0) divisor = 0-divisor;
        if(divisor>dividend) return 0;
        int res= 0;
        long now = divisor;
        int b = 1;
        while(true){
            if((now<<=1)<=dividend){
                b <<= 1;
            }else if((now>>=1)+divisor<=dividend){
                res += b;
                dividend = dividend-(int)now;
                now = divisor;
                b = 1;
            }else{
                res += b;
                break;
            }

        }
        if(!zheng) res = 0-res;
        return res;
    }
}
