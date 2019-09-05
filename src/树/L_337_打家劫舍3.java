/**
 * Copyright (C), 2018-2019, FileName: L_337_打家劫舍3 Author:   Administrator Date:     2019/9/1 21:41 Description:
 */
package 树;

import commom.TreeNode;

public class L_337_打家劫舍3 {
    public int rob(TreeNode root) {
        return sonRob(root,true);
    }

    public int sonRob(TreeNode root,boolean flag){
        if(root==null) return 0;
        if(flag){
            return Math.max(root.val+sonRob(root.left,false)+sonRob(root.right,false),sonRob(root.left,true)+sonRob(root.right,true));
        }else {
            return sonRob(root.left,true)+sonRob(root.right,true);
        }
    }
    /**
     * 树形DP 用数组[0]保存选择当前节点的结果，[1]保存不选择当前节点的最大值
     * @param root
     * @return
     */
    public int rob1(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }
    public int[] helper(TreeNode r){
        if(r==null) return new int[2];
        int[] res = new int[2];
        int[] left =helper(r.left);
        int[] right =helper(r.right);
        res[0] = r.val+left[1]+right[1];
        res[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return res;
    }
}