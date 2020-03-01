package 牛客;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 排列计数_爱奇艺 {
    static int N;
    static int[] arr;
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N-1];
        res = 0;
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int[] nums = new int[N];
        permutation(nums,0,new HashSet<>());
        System.out.println(res);

    }
    public static void permutation(int[] nums, int index, Set<Integer> set){
        if(index==N){
            res++;
            return;
        }
        for(int i=1;i<=N;i++){
            if(set.contains(i)) continue;
            nums[index] = i;
            if(index>0){
                if(arr[index-1]==1&&(nums[index]<nums[index-1])) continue;
                if(arr[index-1]==0&&(nums[index]>nums[index-1])) continue;
            }
            set.add(i);
            permutation(nums,index+1,set);
            set.remove(i);
        }
    }
}
