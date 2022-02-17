//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
// 👍 1541 👎 0


package leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numIslands(char[][] grid) {
            //return dfsSolution(grid);
            return ufSolution(grid);
        }

        private int ufSolution(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            UnionFind unionFind = new UnionFind(grid);
            int[][] tmp = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        for (int[] ints : tmp) {
                            int i1 = i + ints[0];
                            int j1 = j + ints[1];
                            if (i1 < 0 || i1 >= row || j1 < 0 || j1 >= col) {
                                continue;
                            }
                            if (grid[i1][j1] == '1') {
                                unionFind.union(i * col + j, i1 * col + j1);
                            }

                        }
                    }

                }
            }


            return unionFind.count;
        }

        private int dfsSolution(char[][] grid) {
            int res = 0;
            int col = grid[0].length;
            int row = grid.length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        res++;
                    }
                }
            }

            return res;
        }

        private void dfs(char[][] grid, int row, int col) {
            if (col < 0 || col >= grid[0].length || row < 0 || row >= grid.length) {
                return;
            }
            if (grid[row][col] == '0') {
                return;
            }

            grid[row][col] = '0';

            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);

        }
    }

    class UnionFind {

        int[] parent;

        int count = 0;

        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            this.parent = new int[row * col];


            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * col + j] = i * col + j;
                        count++;
                    }
                }
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }

            parent[rootQ] = rootP;
            count--;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
