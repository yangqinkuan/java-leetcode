/**
 * FileName: L_538_把二叉树转换为累加树
 * Author:   yangqinkuan
 * Date:     2019-8-19 10:38
 * Description:
 */

package 树;

import commom.TreeNode;

import java.util.Stack;

/*
* 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

例如：

输入: 二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
* */
public class L_538_把二叉树转换为累加树 {
    int count = 0;
    int preNum;
    //问题的本质是后续遍历，然后记录累计和count;遍历到每个节点就 +count  然后count= 该节点的值
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return root;
        }
        convertBST(root.right);
        root.val += count;
        count = root.val;
        convertBST(root.left);
        return root;
    }
    //非递归后续遍历， 先直接将根节点的每个右节点压入栈，然后.....
    public TreeNode convertBST1(TreeNode root) {
        if(root == null)
            return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //stack.add(root);
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += preNum;
            preNum = node.val;
            if(node.left != null)
                node = node.left;
            else
                node = null;
        }
        return root;
    }
}
