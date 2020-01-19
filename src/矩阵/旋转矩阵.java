package 矩阵;

public class 旋转矩阵 {
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
