package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arrs = new int[5][];
        for(int i=0;i<5;i++){
            String str = in.nextLine();
            String[] strs = str.split(",");
            int[] nums = new int[strs.length];
            for(int j=0;j<strs.length;j++){
                nums[j] = Integer.parseInt(strs[j]);
            }
            arrs[i] = nums;
        }
        permutation(arrs,0,new ArrayList<>());
        in.close();
    }

    public static void permutation(int[][] arrs, int index, List<Integer> list){
        if(index==5){
            for(int i=0;i<4;i++){
                System.out.print(list.get(i)+",");
            }
            System.out.print(list.get(4));
            System.out.println();
            return;
        }
        int[] nums = arrs[index];
        for(int j=0;j<nums.length;j++){
            if(list.size()==0||nums[j]>list.get(list.size()-1)){
                list.add(nums[j]);
                permutation(arrs,index+1,list);
                list.remove(list.size()-1);
            }
        }
    }
}
