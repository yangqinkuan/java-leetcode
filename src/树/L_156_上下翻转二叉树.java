package 树;

import commom.TreeNode;

public class L_156_上下翻转二叉树 {

    TreeNode res;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    public TreeNode dfs(TreeNode root){
        if(root==null||root.left==null){
            if(res==null) res = root;
            return root;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        left.left = right;
        left.right = root;
        // 关键点注意断链，防止死循环
        root.left = null;
        root.right = null;
        return root;
    }
}
