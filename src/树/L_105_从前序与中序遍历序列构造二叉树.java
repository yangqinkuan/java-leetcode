/**
 * FileName: L_105_从前序与中序遍历序列构造二叉树
 * Author:   yangqinkuan
 * Date:     2019-11-18 17:43
 * Description:
 */

package 树;

import commom.TreeNode;

public class L_105_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        return buildSonTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode buildSonTree(int[] preorder,int preleft,int preright,int[] inorder,int inleft,int inright){
        if(preleft>preright) return null;
        if(preleft==preright){
            return new TreeNode(preorder[preleft]);
        }
        TreeNode head = new TreeNode(preorder[preleft]);
        int i = inleft;
        for(;i<inright;i++){
            if(preorder[preleft]==inorder[i]){
                break;
            }
        }
        head.left = buildSonTree(preorder,preleft+1,preleft+i-inleft,inorder,inleft,i-1);
        head.right = buildSonTree(preorder,preleft+1+i-inleft,preright,inorder,i+1,inright);
        return head;
    }
}
