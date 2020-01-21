package 树;

import commom.TreeNode;

public class L_285_二叉搜索树中的顺序后继 {




    /**
     * 递归遍历
     */

    TreeNode res;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorder(root,p);
    }
    public TreeNode inorder(TreeNode root,TreeNode p){
        if(root==null) return null;
        TreeNode left = inorder(root.left,p);
        if(res==null&&root.val>p.val){
            res=root;
            return res;
        }
        TreeNode right = inorder(root.right,p);

        return left==null?right:left;
    }
}
