/**
 * FileName: 寻找树的子结构
 * Author:   yangqinkuan
 * Date:     2019-8-13 11:53
 * Description:
 */

package 剑指;

import commom.TreeNode;

public class 寻找树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return isSubTree( root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
    }
}
