package 牛客;

import java.util.Scanner;

public class 切割块 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int k = sc.nextInt();
        long blockx = 1;
        long blocky = 1;
        long blockz = 1;

        while(k>0&&(x>1||y>1||z>1)){
            if(k>0&&x>1){
                blockx++;
                k--;
            }
            if(k>0&&y>1){
                blocky++;
                k--;
            }
            if(k>0&&z>1){
                blockz++;
                k--;
            }
        }
        long res = blockx*blocky*blockz;
        System.out.println(res);
    }
}
