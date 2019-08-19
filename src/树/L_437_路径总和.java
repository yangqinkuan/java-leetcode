/**
 * Copyright (C), 2018-2019,
 * FileName: L_437_路径总和
 * Author:   Administrator
 * Date:     2019/8/18 22:56
 * Description:
 */
package 树;

import commom.TreeNode;

import java.util.HashMap;

public class L_437_路径总和 {
    /**
     *  思路:1、遍历每个节点   2、对每个节点进行往下寻找路径  注意 sum为0的时候仍可以往下寻找  比如后面是-1 和 1
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        return path(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    public int path(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        if(root.val==sum){
            return 1+path(root.left,sum-root.val)+path(root.right,sum-root.val);
        }
        return path(root.left,sum-root.val)+path(root.right,sum-root.val);
    }

    /**
     * 非递归实现
     */
    public int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return helper(root, map, sum, 0);
    }

    int helper(TreeNode root, HashMap<Integer, Integer> map, int sum, int pathSum){
        int res = 0;
        if(root == null) return 0;

        pathSum += root.val;
        res += map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        res = helper(root.left, map, sum, pathSum) + helper(root.right, map, sum, pathSum) + res;
        map.put(pathSum, map.get(pathSum) - 1);
        return res;
    }

}