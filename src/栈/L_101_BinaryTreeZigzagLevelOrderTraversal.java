/**
 * FileName: L_101_BinaryTreeZigzagLevelOrderTraversal
 * Author:   yangqinkuan
 * Date:     2019-5-17 17:57
 * Description:
 */

package 栈;

import java.util.*;

public class L_101_BinaryTreeZigzagLevelOrderTraversal {
    List ans = new ArrayList();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        bfs(root);
        return ans;
    }

    private void bfs (TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index =1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List one = new ArrayList();
            while((size--)>0){
                TreeNode n = queue.poll();
                one.add(n.val);
                if(n.left !=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
            if(index%2==0){
                Collections.reverse(one);
            }
            index++;
            ans.add(one);

        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
}
