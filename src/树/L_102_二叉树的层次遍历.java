/**
 * FileName: L_102_二叉树的层次遍历
 * Author:   yangqinkuan
 * Date:     2019-8-20 9:00
 * Description:
 */

package 树;

import commom.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L_102_二叉树的层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        List<Integer> list = new ArrayList<>();
        while (queue1.size()!=0){
            TreeNode node = queue1.pop();
            list.add(node.val);
            if(node.left!=null) queue2.add(node.left);
            if(node.right!=null) queue2.add(node.right);
            if(queue1.size()==0){
                res.add(list);
                list = new ArrayList<>();
                while (queue2.size()!=0){
                    queue1.add(queue2.pop());
                }
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            // start the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }
}
