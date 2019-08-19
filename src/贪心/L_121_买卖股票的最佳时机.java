/**
 * FileName: L_121_买卖股票的最佳时机
 * Author:   yangqinkuan
 * Date:     2019-8-13 14:40
 * Description:
 */

package 贪心;

public class L_121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int res = 0;
        int min = prices[0];
        int max = prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
                max = min;
            }
            if(prices[i]>max){
                max = prices[i];
            }
            res = Math.max(res,max-min);
        }
        return res;
    }
}
