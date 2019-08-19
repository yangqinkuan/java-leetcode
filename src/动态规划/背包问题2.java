/**
 * FileName: 背包问题2
 * Author:   yangqinkuan
 * Date:     2019-8-16 16:43
 * Description:
 */

package 动态规划;

public class 背包问题2 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    /* 所求值为最大价值 最大价值与 背包容量，物品负重，物品价值有关
        递推公式dp[i][m] = max(d[i-1][m],dp[i-1][m-A[i]]+V[i])
        根据题意观察出，结果一定是使用所有背包容量最大
        所以递推公式与   新遍历物品大小有关，和到达上一个物品时能获得的最大价值有关，所以，将结果表达式更新为 dp[m]
        d[m] 为遍历到达某个物品时，能存储的最大价值，所以从后往前遍历，当前更新节点之前的都是遍历到上一个物品时的数据
     *
    * */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[] dp = new int[m+1];
        for(int i=0;i<A.length;i++){
            for(int j=m;j>=0;j--){
                if(j<A[i]){
                    continue;
                }
                dp[j] = Math.max(dp[j],dp[j-A[i]]+V[i]);
            }
        }
        return dp[m];
    }
}
