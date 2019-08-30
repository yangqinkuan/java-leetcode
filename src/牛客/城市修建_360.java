/**
 * FileName: 城市修建_360
 * Author:   yangqinkuan
 * Date:     2019-8-30 17:08
 * Description:
 */

package 牛客;


import java.util.Scanner;

/**
 *

 有一个城市需要修建，给你N个民居的坐标X,Y，问把这么多民居全都包进城市的话，城市所需最小面积是多少（注意，城市为平行于坐标轴的正方形）

 输入描述:

 第一行为N，表示民居数目（2≤N≤1000）


 输出描述:

 城市所需最小面积


 输入例子1:

 2
 0 0
 2 2


 输出例子1:

 4


 输入例子2:

 2
 0 0
 0 3


 输出例子2:

 9


 */

public class 城市修建_360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] xy = new long[n][2];
        for(int i=0;i<2*n;i=i+2){
            xy[i/2][0] = scanner.nextInt();
            xy[i/2][1] = scanner.nextInt();
        }
        long minx = Integer.MAX_VALUE;
        long maxx = Integer.MIN_VALUE;
        long miny = Integer.MAX_VALUE;
        long maxy = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            long x = xy[i][0];
            long y = xy[i][1];
            minx = Math.min(minx,x);
            maxx = Math.max(maxx,x);
            miny = Math.min(miny,y);
            maxy = Math.max(maxy,y);
        }
        long len = Math.max(maxy-miny,maxx-minx);
        System.out.println(len*len);
    }
}
