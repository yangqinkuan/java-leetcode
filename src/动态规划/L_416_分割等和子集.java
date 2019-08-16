/**
 * FileName: L_416_分割等和子集
 * Author:   yangqinkuan
 * Date:     2019-8-16 9:59
 * Description:
 */

package 动态规划;

public class L_416_分割等和子集 {
    public static void main(String[] args) {
        System.out.println(backPack(10,new int[]{3,4,8,5}));
    }
    public static int backPack(int m, int[] A) {
       /* if(A.length==0||m==0){
            return 0;
        }
        int[][] dp = new int[A.length+1][m+1];
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
        return dp[A.length-1][m];*/
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

}
