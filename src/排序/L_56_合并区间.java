/**
 * FileName: L_56_合并区间
 * Author:   yangqinkuan
 * Date:     2019-7-16 15:59
 * Description:
 */

package 排序;

import java.util.*;

public class L_56_合并区间 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> resultList = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(resultList.size()==0){
                resultList.add(intervals[i]);
            }else {
                if(resultList.get(resultList.size()-1)[1]>=intervals[i][0]){
                    if(resultList.get(resultList.size()-1)[1]>=intervals[i][1]){
                        continue;
                    }
                    resultList.get(resultList.size()-1)[1] = intervals[i][1];
                }else {
                    resultList.add(intervals[i]);
                }
            }
        }
        int[][] result = new int[resultList.size()][2];
        for(int i=0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] demo = new int[4][2];
        demo[0] = new int[]{1,3};
        demo[1] = new int[]{2,6};
        demo[2] = new int[]{8,10};
        demo[3] = new int[]{15,18};
        merge(demo);
    }
}
