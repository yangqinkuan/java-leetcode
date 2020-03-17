package test;

import java.util.Arrays;

public class Test02 {


    public static void main(String[] args) {
        Test02 test02 = new Test02();
        int count = 0;
        for(int i=0;i<=1680;i++){
            if(test02.isStrobogrammatic(String.valueOf(i))){
                count++;
                System.out.println(i);
            }
        }
    }

    public boolean isStrobogrammatic(String num) {
        int[] table = new int[10];
        Arrays.fill(table,-1);
        build(table);
        int left = 0;
        int right = num.length()-1;
        while(left<=right){
            int var1 = table[num.charAt(left)-'0'];
            if(var1==-1||var1!=(num.charAt(right)-'0')) return false;
            left++;
            right--;
        }
        return true;
    }
    public void build(int[] table){
        table[0] = 0;
        table[1] = 1;
        table[6] = 9;
        table[9] = 6;
        table[8] = 8;

    }
}
