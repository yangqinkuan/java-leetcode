import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * FileName: Test1
 * Author:   yangqinkuan
 * Date:     2019-11-28 19:30
 * Description:
 */

public class Test1 {
    public static void main(String[] args) {
        /*ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("asdasd");*/
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        new Test1().canCompleteCircuit(gas,cost);


    }
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for(int i=0;i<gas.length;i++){
            int count = gas.length;
            int index = i;
            int remain = 0;
            while(count>0&&remain>=0){
                remain = remain+gas[index%gas.length]-cost[index%gas.length];
                index++;
                count--;
            }
            if(count==0) return i;
        }
        return -1;
    }
}
