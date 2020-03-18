package 双指针;

import java.util.ArrayList;
import java.util.List;

public class 和为S的连续正数序列 {

    public static void main(String[] args) {
        和为S的连续正数序列 test = new 和为S的连续正数序列();
        test.findContinuousSequence(3);
    }

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 1;
        int sum = 1;
        while(true){
            if(sum==target){
                List<Integer> list = new ArrayList<>();
                for(int i=left;i<=right;i++){
                    list.add(i);
                }
                res.add(list);
                right++;
                if(right==target) break;
                sum += right;

            }else if(sum>target){
                sum -= left;
                left++;
            }else{
                right++;
                if(right==target) break;
                sum += right;
            }
        }
        int[][] result = new int[res.size()][];
        for(int i=0;i<res.size();i++){
            int[] nums = new int[res.get(i).size()];
            for(int j=0;j<nums.length;j++){
                nums[j] = res.get(i).get(j);
            }
            result[i] = nums;
        }
        return result;
    }
}
