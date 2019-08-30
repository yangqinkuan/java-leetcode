/**
 * FileName: L_452_用最少的数量的箭引爆气球
 * Author:   yangqinkuan
 * Date:     2019-8-23 8:15
 * Description:
 */

package 数组;

import com.sun.org.apache.regexp.internal.RE;
import commom.TreeNode;

import java.util.*;

public class L_452_用最少的数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        int res = 0;
        if(points.length==0){
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> o1[0]-o2[0]);
        int left = points[0][0];
        int right = points[0][1];
        res = 1;
        for(int i=0;i<points.length;i++){
            if(!(points[i][0]>right)){
                left = Math.max(left,points[i][0]);
                right = Math.min(right,points[i][1]);
            }else {
                res += 1;
                left = points[i][0];
                right = points[i][1];
            }
        }
        return res;
    }
}
