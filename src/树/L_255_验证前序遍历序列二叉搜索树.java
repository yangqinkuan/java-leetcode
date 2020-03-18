package 树;

import java.util.Stack;

/**
 * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
 *
 * 你可以假定该序列中的数都是不相同的。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [5,2,6,1,3]
 * 输出: false
 * 示例 2：
 *
 * 输入: [5,2,1,3,6]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class L_255_验证前序遍历序列二叉搜索树 {


    // 利用单调栈并结合二叉搜索树的性质来解决

    /**
     * 结论
     * 维护一个单调递减的栈，以及最新pop出来的值。待push进栈的节点值必须大于已经pop出来的所有元素的值，才能是合法的BST。
     * 思路
     * BST的性质是左子树小于root，右子树大于root，所以校验这个性质即可。
     * 单调递减栈的单调性用来假设root到左子树的性质正确，再用待push进栈的节点值必须大于已经pop出来的所有元素的值来校验root到右子树的性质
     * 得益于单调性，已经pop出来的所有元素的值是不断递增的，所以用最新的值来校验即可
     * 时间复杂度：O(n)，每个元素最多进出栈各1次
     *
     * 作者：shinnqy
     * 链接：https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/solution/dan-diao-zhan-xiao-yan-bstqian-xu-bian-li-by-shinn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {

        Stack<Integer> stack = new Stack<>();
        int cur_pop_max = Integer.MIN_VALUE;
        for(int i=0;i<preorder.length;i++){
            while(stack.size()!=0&&stack.peek()<=preorder[i]){
                cur_pop_max = stack.pop();
            }

            if(preorder[i]<=cur_pop_max) return false;
            stack.add(preorder[i]);
        }
        return true;
    }

    /**
     * 偏暴力解法
     * @param preorder
     * @return
     */
    public boolean verifyPreorder1(int[] preorder) {
        if(preorder.length==0) return true;
        int cut = preorder.length;
        for(int i=1;i<=cut-1;i++){
            if(preorder[i]>preorder[0]){
                cut = i;
                break;
            }
        }
        return verify(preorder,1,cut-1,preorder[0],true)&verify(preorder,cut,preorder.length-1,preorder[0],false);
    }

    public boolean verify(int[] preorder,int start,int end,int pre,boolean left){
        if(start>end) return true;
        for(int i=start;i<=end;i++){
            if(left&&preorder[i]>=pre) return false;
            if(!left&&preorder[i]<=pre) return false;
        }
        int cut = end+1;
        for(int i=start+1;i<=end;i++){
            if(preorder[i]>preorder[start]){
                cut = i;
                break;
            }
        }
        return verify(preorder,start+1,cut-1,preorder[start],true)&verify(preorder,cut,end,preorder[start],false);


    }
}
