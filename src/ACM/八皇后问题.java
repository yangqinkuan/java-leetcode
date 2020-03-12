package ACM;

public class 八皇后问题 {
    static int[] C = new int[4];
    static int n = 4;
    static int tot;
    static boolean[][] vis = new boolean[3][8];
    public static void main(String[] args) {
        //search1(4);
        search(0);
        System.out.println(tot);
    }

    public static void search(int cur){
        if(cur==n){
            System.out.println("=============================");
            tot++;
        }else{
            for(int i=0;i<n;i++){
                int ok = 1;
                C[cur] = i;
                for(int j=0;j<cur;j++){
                    // 判断是否在同一列，判断是否在同一右斜线，判断是否在同意左斜线
                    if(C[cur]==C[j]||cur-C[cur]==j-C[j]||cur+C[cur]==j+C[j]){
                        ok = 0;
                        break;
                    }
                }
                if(ok==1){
                    search(cur+1);
                }
            }
        }
    }

    public static void search1(int cur){
        if(cur==n){
            tot++;
        }else{
            for(int i=0;i<n;i++){
                // 利用visit数组记录同列，左斜线，右斜线是否有棋子
                if(!vis[0][i]&&!vis[1][cur+i]&&!vis[2][cur-i+n]){
                    vis[0][i] = vis[1][cur+i] = vis[2][cur-i+n] = true;
                    search1(cur+1);
                    vis[0][i] = vis[1][cur+i] = vis[2][cur-i+n] = false;
                }
            }
        }
    }
}
