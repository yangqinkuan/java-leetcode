/**
 * FileName: L_85_MaximalRectangle
 * Author:   yangqinkuan
 * Date:     2019-5-17 15:20
 * Description:
 */

package 栈;

import java.util.Stack;

public class L_85_MaximalRectangle {

    /*
    Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
此题跟84题本质上差不多,分别以每层为底部，然后用该层往上的1构成矩形，然后依次求矩形的最大面积,若底部为0，则该下标矩形为0，然后利用4题方法

    * */

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            intMatrix[0][j] = matrix[0][j] - '0';
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]=='1'){
                    intMatrix[i][j] = intMatrix[i-1][j]+1;
                }else {
                    intMatrix[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            max = Math.max(max,largestRectangleArea(intMatrix[i]));
        }
        return max;
    }


    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for(int i=0;i<heights.length;i++) {
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]) {
                int cur = stack.pop();
                int len = stack.isEmpty()?i:i-stack.peek()-1;
                area=Math.max(area, len*heights[cur]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            int len = stack.isEmpty()?heights.length:heights.length-stack.peek()-1;
            area=Math.max(area, len*heights[cur]);
        }
        return area;
    }

    public static void main(String[] args) {
        char[][] a = { {'0','0','0'},{'0','0','0'},{'0','0','0'},{'0','0','0'}};
        new L_85_MaximalRectangle().maximalRectangle(a);
    }
}
