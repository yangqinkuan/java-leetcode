/**
 * FileName: L_39_组合总数
 * Author:   yangqinkuan
 * Date:     2019-9-3 14:27
 * Description:
 */

package 数组;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_39_组合总数 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates,target);
        for (List<Integer> list:res) {
            for (Integer num: list) {
                System.out.print(num);
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }


    //深度优先遍历加剪枝
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        sonMothod(candidates,0,target,new ArrayList<>());
        return res;
    }
    public static void sonMothod(int[] candidates,int i,int target,List<Integer> list){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(list);
            return;
        }
        if(i==candidates.length) {
            return;
        }
        for(int j=0;j<=target/candidates[i]+1;j++){
            List newList = new ArrayList(list);
            for(int k=0;k<j;k++){
                newList.add(candidates[i]);
            }
            sonMothod(candidates,i+1,target-j*candidates[i],newList);
        }
    }
}
