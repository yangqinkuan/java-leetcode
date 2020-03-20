package 常用算法模板.并查集练习;

public class L_323_无向图中连通分量地数目 {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge: edges) {
            unionFind.union(edge[0],edge[1]);
        }
        return unionFind.count;
    }
    class UnionFind {
        int count;
        int[] parent;
        int[] weight;

        public UnionFind(int N) {
            count = N;
            parent = new int[N];
            weight = new int[N];
            for(int i=0;i<N;i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int p,int q){
            int root_p = find(p);
            int root_q = find(q);
            if(weight[root_p]>weight[root_q]){
                parent[root_q] = root_p;
                weight[root_p] += weight[root_q];
            }else{
                parent[root_p] = root_q;
                weight[root_q] += weight[root_p];
            }
            count--;
        }
        public int find(int p){
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

    }
}


