/**
 * Copyright (C), 2018-2019,
 * FileName: L_78_子集
 * Author:   Administrator
 * Date:     2019/8/22 23:15
 * Description:
 */
package 数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L_78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> queue = new LinkedList<>();
        if(nums.length==0){
            return queue;
        }

        for(int i=0;i<nums.length;i++){
            int k = queue.size();
            while (k>0){
                List<Integer> list = queue.pop();
                List<Integer> nextList = new ArrayList<>(list);
                list.add(nums[i]);
                queue.add(list);
                queue.add(nextList);
                k--;
            }
            List<Integer> templist = new ArrayList<>();
            templist.add(nums[i]);
            queue.add(templist);
        }
        queue.add(new ArrayList<>());
        return queue;
    }


    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> queue = new LinkedList<>();
        if(nums.length==0){
            return queue;
        }
        queue.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
           int size = queue.size();
           for(int j=0;j<size;j++){
               List<Integer> newTemp = new ArrayList<>(queue.get(j));
               newTemp.add(nums[i]);
               queue.add(newTemp);
           }
        }
        return queue;
    }

    /**
     * 顺序过程就是   [1,2,3]   1 12 13 123 2 23 3
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}