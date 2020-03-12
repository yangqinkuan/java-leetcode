package 经典题目;


import javafx.util.Pair;

import java.util.*;

/**
 * 1376. 通知所有员工所需的时间
 * 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 *
 * 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 *
 * 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
 *
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一消息）。
 *
 * 返回通知所有员工这一紧急消息所需要的 分钟数 。
 */


public class L_1376_通知所有员工所需的时间 {

    public static void main(String[] args) {
        L_1376_通知所有员工所需的时间 test = new L_1376_通知所有员工所需的时间();
    }

    /**
     * BFS解法
     * @param n
     * @param headID
     * @param manager
     * @param informTime
     * @return
     */

    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        boolean[] table = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<manager.length;i++){
            List<Integer> list = map.get(manager[i]);
            if(list==null) list = new ArrayList<>();
            list.add(i);
            map.put(manager[i],list);
        }
        LinkedList<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(headID,0));
        while(queue.size()!=0){
            Pair<Integer,Integer> pair = queue.pollFirst();
            int cur = pair.getKey();
            int sum = pair.getValue();
            if(informTime[cur]==0){
                res = Math.max(res,sum);
                continue;
            }
            List<Integer> list = map.get(cur);
            for (Integer son:list) {
                queue.add(new Pair<>(son,sum+informTime[cur]));
            }
        }

        return res;
    }

    /**
     * DFS 解法。
     */
    int res = 0;
    public int numOfMinutes1(int n, int headID, int[] manager, int[] informTime) {
        boolean[] table = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<manager.length;i++){
            List<Integer> list = map.get(manager[i]);
            if(list==null) list = new ArrayList<>();
            list.add(i);
            map.put(manager[i],list);
        }
        dfs(headID,manager,informTime,0,map);
        return res;
    }

    public void dfs(int cur,int[] manager,int[] informTime,int sum,Map<Integer,List<Integer>> map){
        if(informTime[cur]==0){
            res = Math.max(res,sum);
            return;
        }
        List<Integer> list = map.get(cur);
        for (Integer son:list) {
            dfs(son,manager,informTime,sum+informTime[cur],map);
        }
    }


    /**
     * 自底向上
     * @param n
     * @param headID
     * @param manager
     * @param informTime
     * @return
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for(int i=0;i<manager.length;i++){
            // 说明为叶子节点
            if(informTime[i]==0){
                int cur = manager[i];
                int sum = 0;
                while(cur!=-1){
                    sum += informTime[cur];
                    cur = manager[cur];
                }
                res = Math.max(res,sum);
            }

        }
        return res;
    }
}
