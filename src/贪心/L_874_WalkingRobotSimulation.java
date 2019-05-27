/**
 * FileName: L_874_WalkingRobotSimulation
 * Author:   yangqinkuan
 * Date:     2019-5-22 15:28
 * Description:
 */

package 贪心;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L_874_WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int max = 0;
        int[][] dx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int k = 0;
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            map.put(obstacles[i][0] + "," + obstacles[i][1], true);
        }
        int p = 0, q = 0;
        for (int command : commands) {
            if (command == -1) {
                k = (k + 1) % 4;
            } else if (command == -2) {
                k = (k + 4 - 1) % 4;
            } else {
                int cur[] = dx[k];
                for (int i = 0; i < command; i++) {
                    if (map.containsKey((p + cur[0]) + "," + (q + cur[1]))) {
                        break;
                    }
                    p += cur[0];
                    q += cur[1];
                }
                max = Math.max(max, p * p + q * q);
            }
        }
        return max;
    }
    public int robotSim1(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int fangxiang = 0;
        int max = 0;
        Set<String> obstacleS = new HashSet<>();
        for(int i=0;i<obstacles.length;i++){
            obstacleS.add(String.valueOf(obstacles[i][0])+","+String.valueOf(obstacles[i][1]));
        }
        for(int i=0;i<commands.length;i++){
            if(commands[i]==-1){
                fangxiang = (fangxiang+1)%4;
            }else if(commands[i]==-2){
                fangxiang = (fangxiang-1+4)%4;
            }else {
                for(int j=0;j<commands[i];j++){
                    if(fangxiang==0){
                        if(!obstacleS.contains(String.valueOf(x)+","+String.valueOf(y+1))){
                            y++;
                        }
                    }else if(fangxiang==1){
                        if(!obstacleS.contains(String.valueOf(x+1)+","+String.valueOf(y))){
                            x++;
                        }
                    }else if(fangxiang==2){
                        if(!obstacleS.contains(String.valueOf(x)+","+String.valueOf(y-1))){
                            y--;
                        }
                    }else {
                        if(!obstacleS.contains(String.valueOf(x-1)+","+String.valueOf(y))){
                            x--;
                        }
                    }
                }

            }
            max = Math.max(max,x*x+y*y);
        }
        return max;
    }

    public static void main(String[] args) {
        int [][] s = new int[1][];
        s[0] = new int[]{2,4};
       /* s[0] = new int[]{-4,-1};
        s[1] = new int[]{1,-1};
        s[2] = new int[]{1,4};
        s[3] = new int[]{5,0};
        s[4] = new int[]{4,5};
        s[5] = new int[]{-2,-1};
        s[6] = new int[]{2,-5};
        s[7] = new int[]{5,1};
        s[8] = new int[]{-3,-1};
        s[9] = new int[]{5,-3};*/

        System.out.println(new L_874_WalkingRobotSimulation().robotSim(new int[]{4,-1,4,-2,4},s));
    }
}
