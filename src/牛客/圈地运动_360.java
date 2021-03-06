/**
 * FileName: 圈地运动_360
 * Author:   yangqinkuan
 * Date:     2019-8-30 18:03
 * Description:
 */

package 牛客;

import java.util.Scanner;

/**
 *  圈地运动，就是用很多木棍摆在地上组成一个面积大于0的多边形～
 *
 * 小明喜欢圈地运动，于是他需要去小红店里面买一些木棍，期望圈出一块地来。小红想挑战一下小明，所以给小明设置了一些障碍。障碍分别是：
 *
 * 1.如果小明要买第i块木棍的话，他就必须把前i-1块木棍都买下来。
 *
 * 2.买了的木棍都必须用在圈地运动中。
 * 那么请问小明最少买多少根木棍，才能使得木棍围成的图形是个面积大于0多边形呢？
 *
 * 输入描述:
 *
 * 第一行一个数n，表示木棍个数。
 * 第二行n个数，第i个数表示第i个木棍的长度ai
 * 1<=n<=10000
 * 1<=ai<=10000
 *
 *
 * 输出描述:
 *
 * 输出一个数，表示最少需要的木棍个数，如果无解输出-1
 *
 *
 * 输入例子1:
 *
 * 3
 * 6 8 10
 *
 *
 * 输出例子1:
 *
 * 3
 */
public class 圈地运动_360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        int max = 0;
        int sum = 0;
        int i;
        for(i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(max,nums[i]);
            if(sum-max>max){
                System.out.println(i+1);
                break;
            }
        }
        if(i==n) System.out.println(-1);


    }
}
