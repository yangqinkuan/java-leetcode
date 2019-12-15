/**
 * FileName: L_79_单词搜索
 * Author:   yangqinkuan
 * Date:     2019-12-13 14:40
 * Description:
 */

package 数组;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 采用回溯加剪枝，还有需要考虑的就是可以从任意一个点开始，所以最外层再套一个循环
public class L_79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (son(board,0,word,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean son(char[][] board,int i,String word,int m,int n){
        if(i==word.length()) return true;
        if(m<0||m>=board.length||n<0||n>=board[0].length) return false;
        if(word.charAt(i)!=board[m][n]) return false;
        char temp = board[m][n];
        board[m][n] = '@';
        boolean result = son(board,i+1,word,m-1,n) || son(board,i+1,word,m+1,n) || son(board,i+1,word,m,n+1) || son(board,i+1,word,m,n-1);
        board[m][n] = temp;
        return result;
    }
}
