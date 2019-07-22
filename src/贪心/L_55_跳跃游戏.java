/**
 * FileName: L_55_跳跃游戏
 * Author:   yangqinkuan
 * Date:     2019-6-25 17:20
 * Description:
 */

package 贪心;

enum Index{
    GOOD,BAD,UNKNOWN
}

public class L_55_跳跃游戏 {
/*    给定一个非负整数数组，你最初位于数组的第一个位置。

    数组中的每个元素代表你在该位置可以跳跃的最大长度。

    判断你是否能够到达最后一个位置。

    输入: [2,3,1,1,4]
    输出: true
    解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。

    */
    Index[] memo;
    public boolean canJump1(int[] nums) {
        memo = new Index[nums.length];
        for (int i=0;i<memo.length;i++){
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length-1] = Index.GOOD;
        return canJumpFromPosition(0,nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
        if(memo[position] != Index.UNKNOWN){
            return  memo[position] == Index.GOOD?true:false;
        }
        int furthestJump = Math.min(position+nums[position],nums.length-1);
        for(int nextPosition = position+1;nextPosition<=furthestJump;nextPosition++){
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump(int[] nums){
        int lastPos = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=lastPos){
                lastPos = i;
            }
        }
        return lastPos==0;
    }
}
