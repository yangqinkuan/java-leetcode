/**
 * FileName: L_122_BestTimetoBuyandSellStock
 * Author:   yangqinkuan
 * Date:     2019-5-20 20:34
 * Description:
 */

package 贪心;

public class L_122_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                max += prices[i]-prices[i-1];
            }
        }
        return max;
    }
}
