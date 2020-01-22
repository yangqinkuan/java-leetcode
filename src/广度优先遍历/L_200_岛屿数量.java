package 广度优先遍历;

import java.util.LinkedList;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


public class L_200_岛屿数量 {
    LinkedList<int[]> queue = new LinkedList<>();
    int[][] arr = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int result=0;
        if(grid.length==0) return result;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    result++;
                    queue.add(new int[]{i,j});
                    bfs(grid);
                }
            }
        }

        return result;
    }
    public void bfs(char[][] grid){
        while(queue.size()!=0){
            int[] pair = queue.pollFirst();
            int x = pair[0];
            int y = pair[1];
            if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]=='0') continue;
            grid[x][y] = '0';
            for(int[] step:arr){
                queue.add(new int[]{x+step[0],y+step[1]});
            }
        }
    }
}
