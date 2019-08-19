/**
 * FileName: L_145_BinaryTreePostorderTraversal
 * Author:   yangqinkuan
 * Date:     2019-5-20 10:28
 * Description:
 */

package 栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后续遍历
 */
public class L_145_BinaryTreePostorderTraversal {
    /**
     * 非递归写法  一个二叉节点  根节点1  左子节点2， 右子节点3
     * 先序遍历为  123
     * 后序遍历为  231
     * 考虑利用的先序遍历  23 交换得  132  然后再逆序  得231
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List res = new ArrayList();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> temp = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right);//后将右结点入栈
            temp.add(node.val);                        //逆序添加结点值
        }
        res = new ArrayList(temp);
        while(!temp.isEmpty()){
            res.add(temp.pop());
        }
        return res;
    }

    /**
     * 递归写法
     */
    public List res = new ArrayList();
    public List<Integer> postorderTraversal0(TreeNode root) {
        if(root == null)
            return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }

}
