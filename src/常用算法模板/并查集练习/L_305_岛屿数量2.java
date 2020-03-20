package 常用算法模板.并查集练习;

import java.util.ArrayList;
import java.util.List;

public class L_305_岛屿数量2 {

    public static void main(String[] args) {
        L_305_岛屿数量2 test = new L_305_岛屿数量2();
        test.numIslands2(3,3,new int[][]{{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}});
    }


    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions.length==0) return res;
        boolean[] existed = new boolean[m*n];
        int[][] steps = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        UnionFind unionFind = new UnionFind(m*n);
        for(int[] position:positions){
            existed[position[0]*n+position[1]] = true;
            unionFind.count++;
            for (int[] step: steps) {
                int next_x = position[0]+step[0];
                int next_y = position[1]+step[1];
                if(next_x<0||next_x>=m||next_y<0||next_y>=n) continue;
                int next = (position[0]+step[0])*n+position[1]+step[1];
                if(existed[next]){
                    unionFind.union(position[0]*n+position[1],next);

                }
            }
            res.add(unionFind.count);
        }
        return res;
    }
}
class UnionFind{
    int n;
    int[] parent;
    int count;
    int[] weight;

    public UnionFind(int N){
        this.n = N;
        parent = new int[N];
        weight = new int[N];
        count = 0;
        for(int i=0;i<N;i++){
            parent[i] = i;
            weight[i] = 1;
        }
    }
    public void union(int p,int q){
        int p_root = find(p);
        int q_root = find(q);
        if(p_root==q_root) return;
        if(weight[p_root]>weight[q_root]){
            parent[q_root] = p_root;
            weight[p_root] += weight[q_root];
        }else{
            parent[p_root] = q_root;
            weight[q_root] += weight[p_root];
        }
        count--;
    }

    public int  find(int p){
        while (p!=parent[p]){
            p = parent[p];
        }
        return p;
    }

    public int count(){
        return this.count;
    }
}
