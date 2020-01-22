package 广度优先遍历;

import java.util.LinkedList;

public class L_279_完全平方数 {
    public int numSquares(int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        int step = 0;
        queue.add(n);
        boolean[] record = new boolean[n+1];
        record[n] = true;
        int count = queue.size();
        while(queue.size()!=0){
            step++;
            while(count>0){
                int num = queue.pollFirst();
                count--;
                if(num==0){
                    return step-1;
                }
                int i = 1;
                while(i<=num){
                    int in = num-i*i;
                    if(in<0) break;
                    if(!record[in]){
                        record[in] = true;
                        queue.add(in);
                    }
                    i++;
                }
            }
            count=queue.size();
        }
        return -1;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int numSquares1(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<n+1;i++){
            dp[i] = i;
            for(int j=1;j<i;j++){
                int num = i-j*j;
                if(num<0) break;
                dp[i] = Math.min(dp[i],dp[num]+1);
            }
        }
        return dp[n];
    }
}
