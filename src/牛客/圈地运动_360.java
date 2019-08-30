/**
 * FileName: 圈地运动_360
 * Author:   yangqinkuan
 * Date:     2019-8-30 18:03
 * Description:
 */

package 牛客;

import java.util.Scanner;

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
        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(max,nums[i]);
            if(sum-max>max){
                System.out.println(i+1);
                break;
            }
        }
        System.out.println(-1);

    }
}
