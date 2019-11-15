/**
 * FileName: L_542_01矩阵
 * Author:   yangqinkuan
 * Date:     2019-9-23 17:11
 * Description:
 */

package 矩阵;

public class L_542_01矩阵 {
    public int[][] updateMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]!=0) matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        


        return null;
    }
}
