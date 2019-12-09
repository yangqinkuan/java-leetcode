/**
 * FileName: L_240_搜索二维矩阵2
 * Author:   yangqinkuan
 * Date:     2019-12-9 16:28
 * Description:
 */

package 数组;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_240_搜索二维矩阵2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int m = 0;
        int n = matrix[0].length;
        while(m<matrix.length&&n>=0){
            if(target==matrix[m][n]){
                return true;
            }
            if(target>matrix[m][n]){
                m++;
            }else {
                n--;
            }
        }
        return false;
    }
}
