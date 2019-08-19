/**
 * FileName: L_84_LargestRectangleinHistogram
 * Author:   yangqinkuan
 * Date:     2019-5-16 17:31
 * Description:
 */

package 栈;

import java.util.Stack;

public class L_84_LargestRectangleinHistogram {
    /**
     * 思路用单调栈，，通过寻找矩形左右边缘下标，计算面积
     * @param heights
     * @return
     */
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
        int[] arr = {2,1,2};
        System.out.println(new L_84_LargestRectangleinHistogram().largestRectangleArea(arr));
    }
}
