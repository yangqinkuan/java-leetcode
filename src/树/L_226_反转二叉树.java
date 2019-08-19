/**
 * Copyright (C), 2018-2019,
 * FileName: L_226_反转二叉树
 * Author:   Administrator
 * Date:     2019/8/18 21:32
 * Description:
 */
package 树;

import commom.TreeNode;

public class L_226_反转二叉树 {
    /**
     *  递归，反转每一个节点的左右节点，如果为null返回,否则 左右节点交换
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}