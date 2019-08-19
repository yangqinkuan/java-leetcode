/**
 * FileName: L_144_BinaryTreePreorderTraversal
 * Author:   yangqinkuan
 * Date:     2019-5-20 9:42
 * Description:
 */

package 栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历非递归实现,代码好理解
 */
public class L_144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            list.add(root.val);
            if(root.right!=null){
                stack.add(root.right);
            }
            if(root.left!=null){
                stack.add(root.left);
            }
            if(stack.isEmpty()){
                break;
            }
            root=stack.pop();
        }
        return list;
    }
    //递归实现
    public List<Integer> preorderTraversal0(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }
    private void dfs(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);

        dfs(root.left,list);
        dfs(root.right,list);
    }


}
