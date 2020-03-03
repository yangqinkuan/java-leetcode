package 时间流问题;

import java.util.Arrays;

public class 会议室2 {

    public static void main(String[] args) {
        会议室2 test = new 会议室2();
        System.out.println(test.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));;

    }

    public int minMeetingRooms(int[][] intervals) {
        int[][] arr = new int[intervals.length*2][2];
        int j = 0;
        for(int i=0;i<intervals.length;i++){
            arr[j][0] = intervals[i][0];
            arr[j][1] = 1;
            j++;
            arr[j][0] = intervals[i][1];
            arr[j][1] = 0;
            j++;
        }
        Arrays.sort(arr,(o1, o2)->{return o1[0]-o2[0];});
        int max = 0;
        int len = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i][1]==1){
                len++;
            }else{
                len--;
            }
            max = Math.max(max,len);
        }
        return max;
    }
}
