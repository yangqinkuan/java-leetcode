/**
 * Copyright (C), 2018-2019,
 * FileName: L_104_二叉树的最大深度
 * Author:   Administrator
 * Date:     2019/8/18 0:59
 * Description:
 */
package 树;

import commom.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class L_104_二叉树的最大深度 {

    /**
     * 递归法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    //从顶向下迭代做法，每个节点存储当前所在的深度，下一个节点加一，并统计出max
   /* public int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }*/
}