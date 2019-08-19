/**
 * FileName: 拼多多
 * Author:   yangqinkuan
 * Date:     2019-8-2 18:04
 * Description:
 */

package 贪心;

import java.util.*;

public class 拼多多 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        int length = nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]>nums[0]){
                int temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
            }
            if(nums[i]<nums[length-1]){
                int temp = nums[length-1];
                nums[length-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=1;i<length-1;i++){
            if(nums[i]>nums[1]){
                int temp = nums[1];
                nums[1] = nums[i];
                nums[i] = temp;
            }
            if(nums[i]<nums[length-2]){
                int temp = nums[length-2];
                nums[length-2] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=2;i<length-2;i++){
            if(nums[i]>nums[2]){
                int temp = nums[2];
                nums[2] = nums[i];
                nums[i] = temp;
            }
        }
        int result = Math.max(nums[0]*nums[1]*nums[2],nums[0]*nums[length-1]*nums[length-2]);
        System.out.print(result);
    }

}
