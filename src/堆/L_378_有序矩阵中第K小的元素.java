/**
 * FileName: L_378_有序矩阵中第K小的元素
 * Author:   yangqinkuan
 * Date:     2019-6-21 16:06
 * Description:
 */

package 堆;

public class L_378_有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(k==n*n){
            return matrix[n][n];
        }
        int m = n;
        for(int i=n;i>0;i++){
            if(i*i<k){
                m = i;
                break;
            }
        }
        int x1 = m+1;
        int y1 = 0;
        int x2 = 0;
        int y2 = m+1;
        int result = 0;
        for(int j=k-m*m;j>0;j--){
            if(matrix[x1][y1]<=matrix[x2][y2]){
                result = matrix[x1][y1];
                y1++;
            }else {
                result = matrix[x2][y2];
                x2++;
            }
        }
        return result;
    }
}
