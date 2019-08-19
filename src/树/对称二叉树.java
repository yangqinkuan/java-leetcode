/**
 * Copyright (C), 2018-2019,
 * FileName: 对称二叉树
 * Author:   Administrator
 * Date:     2019/8/17 23:48
 * Description:
 */
package 树;

import commom.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 对称二叉树 {


    /**
     * 递归写法
     * @param root
     * @return
     */

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
       return isEqual(root.left,root.right);
    }


    public boolean isEqual(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return true&&isEqual(left.left,right.right)&&isEqual(left.right,right.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        if(root==null){
            return true;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        linkedList.add(root);

        while (linkedList.size()!=0){
            TreeNode node1 = linkedList.pop();
            TreeNode node2 = linkedList.pop();
            if(node1==null&&node2==null){
                continue;
            }
            if(node1==null||node2==null){
                return false;
            }
            if(node1.val!=node2.val){
                return false;
            }
            linkedList.add(node1.left);
            linkedList.add(node2.right);
            linkedList.add(node1.right);
            linkedList.add(node2.left);
        }
        return true;
    }
}