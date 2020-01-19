package 算法导论;

import java.util.Arrays;

/**
 * 最大子数组问题
 */
public class MaxSonArray {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{3,4}};
        rotate(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;
        while(left<right){
            for(int i=left;i<=right-1;i++){
                swap(matrix,i,matrix.length-1-left,1,matrix[left][i]);
            }
            left++;
            right--;
        }


    }
    public static void swap(int[][] matrix,int x,int y,int i,int value){
        if(i>4) return;
        int temp = matrix[x][y];
        matrix[x][y] = value;
        swap(matrix,y,matrix.length-x-1,++i,temp);
    }
}
