/**
 * FileName: L_543_二叉树的直径
 * Author:   yangqinkuan
 * Date:     2019-8-13 15:32
 * Description:
 */

package 贪心;

import commom.TreeNode;

public class L_543_二叉树的直径 {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        maxDeep(root);
        return max;
    }
    public int maxDeep(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftMax =  maxDeep(node.left);
        int rightMax = maxDeep(node.right);
        max = Math.max(max,leftMax+rightMax);
        return 1+Math.max(leftMax,rightMax);
    }
}
