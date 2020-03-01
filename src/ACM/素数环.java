package ACM;

public class 素数环 {
    boolean[] isp;
    boolean[] vis;

    public static void main(String[] args) {
        素数环 s = new 素数环();
        s.sushuhuan(16);
    }

    public void sushuhuan(int n){
        vis = new boolean[n+1];
        isp = new boolean[n*2+1];
        for(int i=0;i<isp.length;i++){
            isp[i] = isSushu(i);
        }
        int[] A = new int[n];
        A[0] = 1;
        vis[1] = true;
        dfs(1,A,n);
    }

    void dfs(int cur,int[] A,int n){
        if(cur==n&&isp[A[0]+A[n-1]]){
            for(int i=0;i<n;i++){
                System.out.print(A[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=1;i<n;i++){
                if(!vis[i+1]&&isp[A[cur-1]+i+1]){
                    A[cur] = i+1;
                    vis[i+1] = true;
                    dfs(cur+1,A,n);
                    vis[i+1] = false;
                }
            }
        }
    }

    public boolean isSushu(int n){
        int i = 2;
        while(i<n){
            if(n%i==0) return false;
            i++;
        }
        return true;
    }
}
