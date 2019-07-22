/**
 * FileName: L_134_加油站
 * Author:   yangqinkuan
 * Date:     2019-7-3 9:10
 * Description:
 */

package 贪心;

public class L_134_加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int total = 0,sum = 0,start = 0;
       for(int i=0;i<gas.length;i++){
           total += gas[i] -cost[i];
           sum += gas[i]-cost[i];
           if(sum<0){
               start = i+1;
               sum = 0;
           }
       }

        return (total<0)?-1:start;
    }
}
