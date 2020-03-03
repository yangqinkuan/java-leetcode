package 回溯法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */

public class L_254_因子的组合 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),n,2);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> item, int n, int start){
        if(n==1&&item.size()>1){
            res.add(new ArrayList<>(item));
            return;
        }

        for(int i=start;i*i<=n;i++){
            if(n%i==0){
                item.add(i);
                item.add(n/i);
                res.add(new ArrayList<>(item));
                item.remove(item.size()-1);
                dfs(res, item, n/i, i);
                item.remove(item.size() - 1);
            }
        }

    }
}
/**
 * 整数可以被看作是其因子的乘积。
 *
 * 例如：
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 *
 * 注意：
 *
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * 示例 1：
 *
 * 输入: 1
 * 输出: []
 * 示例 2：
 *
 * 输入: 37
 * 输出: []
 * 示例 3：
 *
 * 输入: 12
 * 输出:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * 示例 4:
 *
 * 输入: 32
 * 输出:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factor-combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */