package 常用算法模板;

public class UnionFind {

    //记录连通分量
    private int count;

    //节点x的父节点是parent[x];
    private int[] parent;
    // 新增一个数组记录的"重量" 连通的元素多少
    private int[] size;

    public UnionFind(int n){
        this.count = n;
        parent = new int[n];
        // 最初每棵树只有一个节点
        // 重量应该初始化为1
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 将p和q连接
     * @param p
     * @param q
     */
    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        // 将两颗树合并为一棵树
        if(size[rootP]>size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;// 两个分量合二为一
    }
    // 返回某个节点x的根节点
    private int find(int x){
        while (parent[x] != x){
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * 判断 p 和 q 是否连通
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP==rootQ;
    }

    /**
     * 返回图中有多少个连通分量
     * @return
     */
    public int count(){
        return this.count;
    }
}
