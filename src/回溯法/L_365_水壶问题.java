package 回溯法;

import java.net.ServerSocket;
import java.util.*;

public class L_365_水壶问题 {

    public static void main(String[] args) {
        L_365_水壶问题 test = new L_365_水壶问题();
        System.out.println(test.canMeasureWater(104597,104623,123));
    }
    // BFS
    public boolean canMeasureWater(int x, int y, int z) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));
        while(queue.size()!=0){
            Pair temp = queue.pollFirst();
            if(temp.x==z||temp.y==z||(temp.x+temp.y)==z){
                return true;
            }
            Set<Integer> s = map.get(temp.x);
            if(s==null) s = new HashSet<>();
            if(s.contains(temp.y)) continue;
            s.add(temp.y);
            map.put(temp.x,s);
            queue.addLast(new Pair(x,temp.y));
            queue.addLast(new Pair(temp.x,y));
            queue.addLast(new Pair(temp.x,0));
            queue.addLast(new Pair(0,temp.y));

            if((temp.x+temp.y)<=x){
                queue.addLast(new Pair(temp.x+temp.y,0));
            }else {
                queue.addLast(new Pair(x,temp.y-(x-temp.x)));
            }
            if((temp.x+temp.y)<=y){

                queue.addLast(new Pair(0,temp.x+temp.y));
            }else {
                queue.addLast(new Pair(temp.x-(y-temp.y),y));

            }

        }
        return false;
    }
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
