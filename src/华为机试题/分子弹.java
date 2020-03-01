package 华为机试题;

import java.util.Arrays;

public class 分子弹 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,2,8,22,16,4,10,6,14,20};
        int count = 0;
        System.out.println(Arrays.toString(nums));
        while(!isOK(nums)){
            for(int i=0;i<nums.length;i++){
                if(nums[i]%2==1){
                    nums[i] += 1;
                }
            }
            int add = nums[nums.length-1]/2;
            for(int i=0;i<nums.length;i++){
                nums[i] = nums[i]/2+add;
                add = nums[i] - add;
            }
            count++;
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(count);
    }

    public static boolean isOK(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
