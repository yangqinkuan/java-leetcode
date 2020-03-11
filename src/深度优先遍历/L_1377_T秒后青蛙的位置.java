package 深度优先遍历;

import java.util.*;


/**
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 *
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * 无向树的边用数组 edges 描述，其中 edges[i] = [fromi, toi] 意味着存在一条直接连通 fromi 和 toi 两个顶点的边。
 *
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * 输出：0.16666666666666666
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-position-after-t-seconds
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



public class L_1377_T秒后青蛙的位置 {


    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{1,3},{1,4},{2,5},{2,6}};
        L_1377_T秒后青蛙的位置 test = new L_1377_T秒后青蛙的位置();
        double res = test.frogPosition(6,edges,2,5);
        System.out.println(res);
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        boolean[] visited = new boolean[n+1];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge:edges){
            List<Integer> list1 = map.get(edge[0]);
            List<Integer> list2 = map.get(edge[1]);
            if(list1==null) list1 = new ArrayList<>();
            if(list2==null) list2 = new ArrayList<>();
            list1.add(edge[1]);
            list2.add(edge[0]);
            map.put(edge[0],list1);
            map.put(edge[1],list2);
        }
        visited[1] = true;
        return rate(1,t,target,map,visited);

    }

    public double rate(int cur,int t_remain,int target,Map<Integer,List<Integer>> map,boolean[] visited){
        if(t_remain==0&&cur==target) return 1.0;
        if(t_remain==0&&cur!=target) return 0.0;
        double rate = 0.0;
        List<Integer> list = map.get(cur);
        int count_next = 0;
        if(list!=null){
            for(Integer next:list){
                if(!visited[next]){
                    count_next++;
                    visited[next] = true;
                    double res_next = rate(next,t_remain-1,target,map,visited);
                    rate += res_next;
                    visited[next] = false;
                }
            }
        }
        if(count_next==0&&cur==target) return 1.0;
        if(count_next==0&&cur!=target) return 0.0;
        rate = (1.0/(double) count_next)*rate;
        return rate;
    }
}
