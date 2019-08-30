/**
 * FileName: L_322_零钱兑换
 * Author:   yangqinkuan
 * Date:     2019-8-27 8:47
 * Description:
 */

package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

public class L_322_零钱兑换 {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{186,419,83,408},6249));
    }



    //动态规划，注意初始条件
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int max = amount+1;
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i=0;i<=amount;i++){
            for(int j=coins.length-1;j>=0;j--){
                if(i-coins[j]>=0){
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                }

            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
