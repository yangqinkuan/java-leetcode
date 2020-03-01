package 数组;

public class L_73_矩阵置0 {

    public void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;
        boolean[] hang = new boolean[matrix.length];
        boolean[] lie = new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    hang[i] = true;
                    lie[j] = true;
                }
            }
        }
        for(int i=0;i<hang.length;i++){
            if(hang[i]){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i=0;i<lie.length;i++){
            if(lie[i]){
                for(int j=0;j<matrix.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
