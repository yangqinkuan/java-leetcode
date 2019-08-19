/**
 * FileName: L_94_BinaryTreeInorderTraversal
 * Author:   yangqinkuan
 * Date:     2019-5-17 15:53
 * Description:
 */

package 栈;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 二叉树中序遍历递归和非递归实现
 */
public class L_94_BinaryTreeInorderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        TreeNode node = stack.pop();
        while(node!=null){
            if(node.left==null){
                list.add(node.val);
                while(node.right==null && stack.size()!=0){
                    node = stack.pop();
                    list.add(node.val);
                }
                node = node.right;
            }else {
                stack.add(node);
                node=node.left;
            }

        }
        return list;
    }

         public List<Integer> inorderTraversal0(TreeNode root) {
             List<Integer> list = new ArrayList<>();
             m1(root,list);
             return list;
         }
         public void m1(TreeNode node, List<Integer> list){
             if(node.left!=null){
                 m1(node.left,list);
             }
             list.add(node.val);
             if(node.right!=null){
                 m1(node.right,list);
             }
         }


    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }
}
