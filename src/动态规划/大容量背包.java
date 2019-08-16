/**
 * FileName: 大容量背包
 * Author:   yangqinkuan
 * Date:     2019-8-16 17:47
 * Description:
 */

package 动态规划;

public class 大容量背包 {


    /**
     * 子问题处理，，递归
     * @param s
     * @param v
     * @param c
     * @return
     */
    public long getMaxValue(int s, int[] v, int[] c) {
        // Write your code here
        return maxPackSon(s,c,v.length-1,v);
    }
    public int maxPackSon(int m,int[] c,int i,int[] v){
        //m表示物品容量  i 表示循环到第 i+1件物品
        if(i<0||m<=0){
            return 0;
        }

        if(m<c[i]){
            return maxPackSon(m,c,i-1,v);
        }
        return Math.max(maxPackSon(m-c[i],c,i-1,v)+v[i],maxPackSon(m,c,i-1,v));
    }
}
