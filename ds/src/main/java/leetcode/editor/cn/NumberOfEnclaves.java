//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
//
//
// 示例 2：
//
//
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 500
// grid[i][j] 的值为 0 或 1
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
// 👍 161 👎 0


package leetcode.editor.cn;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int res = 0;

        public int numEnclaves(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            for (int i = 0; i < row; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, col - 1);
            }

            for (int i = 0; i < col; i++) {
                dfs(grid, 0, i);
                dfs(grid, row - 1, i);
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (grid[i][j] == 1) {
                        res += dfs(grid, i, j);
                    }
                }
            }

            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            int row = grid.length;
            int col = grid[0].length;

            if (i < 0 || i >= row || j < 0 || j >= col) {
                return 0;
            }
            if (grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;

            int res = dfs(grid, i - 1, j) +
                    dfs(grid, i + 1, j) +
                    dfs(grid, i, j - 1) +
                    dfs(grid, i, j + 1);

            return 1 + res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
