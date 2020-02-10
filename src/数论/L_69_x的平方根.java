package 数论;

public class L_69_x的平方根 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));;
    }


    public static int mySqrt(int x) {
        if(x==0||x==1) return x;
        long right = x;
        long left = 1;
        long sum = 1;
        while(left<right){
            long mid = left+(right-left)/2;
            sum = mid*mid;
            if(sum==x){
                return (int)mid;
            }else if(sum<x){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return (int)right-1;
    }
}
