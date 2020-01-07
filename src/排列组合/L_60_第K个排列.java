/**
 * FileName: L_60_第K个排列
 * Author:   yangqinkuan
 * Date:     2019-12-27 16:57
 * Description:
 */

package 排列组合;

public class L_60_第K个排列 {

    public static void main(String[] args) {
        System.out.println(new L_60_第K个排列().getPermutation(3,3));
    }

    public String getPermutation(int n, int k) {

        int sum = 1;
        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = i+1;
        }
        for(int i=1;i<n;i++){
            sum*=i;
        }
        StringBuilder sb = new StringBuilder();
        int d = n-1;
        int index = 0;
        while(k>0){
            int num = k/sum;
            if(num>0){
                swap(nums,index,index+num);
                k = k-num*sum-1;
            }
            index++;
            sum = sum/d;
            d--;
        }
        for(int i=0;i<nums.length;i++){
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
