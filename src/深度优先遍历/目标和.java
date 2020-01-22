package 深度优先遍历;

public class 目标和 {
    int result;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0) return result;
        dfs(nums,S+nums[0],1);
        dfs(nums,S-nums[0],1);
        return result;
    }
    public void dfs(int[] nums,int sum,int len){
        if(len==nums.length){
            if(sum==0) result++;
            return;
        }
        dfs(nums,sum+nums[len],len+1);
        dfs(nums,sum-nums[len],len+1);
    }


    public static void main(String[] args) {
        findTargetSumWays1(new int[]{1,1,1,1,1},3);
    }

    public static int findTargetSumWays1(int[] nums, int S) {
        return 0;
    }
}
