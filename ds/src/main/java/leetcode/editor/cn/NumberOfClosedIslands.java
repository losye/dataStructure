//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
//
// 请返回 封闭岛屿 的数目。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
//
// 示例 2：
//
//
//
//
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
//
//
// 示例 3：
//
//
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= grid.length, grid[0].length <= 100
// 0 <= grid[i][j] <=1
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
// 👍 119 👎 0


package leetcode.editor.cn;

public class NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfClosedIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            for (int i = 0; i < row; i++) {
           /* if (grid[i][0] == 0){
                grid[i][0] = 9;
            }
            if (grid[i][col-1] == 0){
                grid[i][col-1]  = 9;
            }*/
                dfs(grid, i, 0);
                dfs(grid, i, col - 1);
            }

            for (int i = 0; i < col; i++) {
            /*if (grid[0][i] == 0){
                grid[0][i] = 9;
            }
            if (grid[row - 1][i] == 0){
                grid[row - 1][i]  = 9;
            }*/
                dfs(grid, 0, i);
                dfs(grid, row - 1, i);
            }

            int res = 0;
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (grid[i][j] == 0) {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }

            return res;
        }

        private void dfs(int[][] grid, int i, int j) {
            int row = grid.length;
            int col = grid[0].length;
            if (i < 0 || i >= row || j < 0 || j >= col) {
                return;
            }
            if (grid[i][j] == 1) {
                return;
            }

            grid[i][j] = 1;

            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
