/**
 * FileName: 背包问题1
 * Author:   yangqinkuan
 * Date:     2019-8-16 16:38
 * Description:
 */

package 动态规划;

public class 背包问题1 {
   /* 方法思想：动态规划，目标是求得能装得得最大值，穷举可得，过程中时间状态有，什么容量能装下多少物品，用J,表示容量状态，i 表示物品状态，状态转移的动作是，对于某件物品在j的情况下是否选择装入,得出动态方程
    前提条件 是 j>物品大小，否则肯定不能装入，前提条件，m为0是目标值肯定为0，
    dp[i][j] = Math.max(dp[i-1][j-A[i]]+A[i],dp[i-1][j]);
1、从底向上，*/
    public int backPack(int m, int[] A) {
        if(A.length==0||m==0){
            return 0;
        }
        int[][] dp = new int[A.length+1][m+1];
        //第一件物品时的初始化,对容量1-m的初始化
        for(int i=0;i<=m;i++){
            if(A[0]<i){
                dp[0][i] = A[0];
            }
        }
        for(int i=1;i<A.length;i++){
            for(int j=1;j<=m;j++){
                if(A[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-A[i]]+A[i],dp[i-1][j]);
                }
            }
        }
        return dp[A.length-1][m];
    }

    //动态规划从顶向下，因为要想装到的数量最大，m肯定越大越好，所以，只要遍历前N个物品，m能装到的值最大，保存就好了
    public int backPack2(int m, int[] A) {
        if(A.length==0||m==0){
            return 0;
        }
        int[] dp = new int[m+1];
        dp[0] = 0;
        for(int i=0;i<A.length;i++){
            for(int j=m;j>=0;j--){
                if(A[i]>j){
                    continue;
                }
                dp[j] = Math.max(dp[j],dp[j-A[i]]+A[i]);
            }

        }
        return dp[m];
    }
    //从顶向下, 递归写法但是会超时
    public int backPack3(int m, int[] A) {
        return maxPackSon(m,A,A.length-1);
    }

    public int maxPackSon(int m,int[] A,int i){
        //m表示物品容量  i 表示循环到第 i+1件物品
        if(i<0||m<=0){
            return 0;
        }

        if(m<A[i]){
            return maxPackSon(m,A,i-1);
        }
        return Math.max(maxPackSon(m-A[i],A,i-1)+A[i],maxPackSon(m,A,i-1));
    }
}
