package 图论;

import java.util.*;

public class L_261_以图判树 {

    public static void main(String[] args) {
        L_261_以图判树 test = new L_261_以图判树();
        test.validTree(5,new int[][]{{0,1},{0,2},{0,3},{1,4}});
    }

    /**
     * 深度优先遍历
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree1(int n, int[][] edges) {

        if(edges.length != n-1) return false;
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 建立邻接表
        for (int[] edge: edges) {
            Set<Integer> set0=map.get(edge[0]);
            Set<Integer> set1=map.get(edge[1]);
            if(set0==null) set0 = new HashSet<>();
            if(set1==null) set1 = new HashSet<>();
            set0.add(edge[1]);
            set1.add(edge[0]);
            map.put(edge[0],set0);
            map.put(edge[1],set1);
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        visited[0] = true;
        while (stack.size()!=0){
            int cur = stack.pop();
            visited[cur] = true;
            Set<Integer> set = map.get(cur);
            if(set==null) continue;
            for (Integer num: set) {
                if(visited[num]) continue;
                stack.add(num);
            }
        }
        for (boolean visit: visited) {
            if(!visit) return false;
        }

        return true;
    }

    // 并查集解法
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1) return false;
        DisjoinSet set = new DisjoinSet(n);
        for(int[] edge:edges){
            set.union(edge[0],edge[1]);
        }
        return set.size==1;
    }


    class DisjoinSet{
        int size;
        int[] parent;
        int[] weight;
        DisjoinSet(int N){
            size = N;
            parent = new int[N];
            weight = new int[N];
            for (int i=0;i<N;i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }

        private void union(int a,int b){
            int ap = find(a);
            int bp = find(b);

            if(ap==bp) return;
            if(weight[ap]>weight[bp]){
                parent[bp] = ap;
                weight[ap] += weight[bp];
            }else{
                parent[ap] = bp;
                weight[bp] += weight[ap];
            }
            size--;
        }

        private int find(int a){
            while (a != parent[a]){
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }
    }

}
