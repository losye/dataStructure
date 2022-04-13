package leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ye
 * @date 2018/8/18 下午9:57
 * 保持城市天际线的最大增高
 *
 * In a 2 dimensional array grid,
 *
 * each value grid[i][j] represents the height of a building located there.
 *
 * We are allowed to increase the height of any number of buildings,
 *
 * by any amount (the amounts can be different for different buildings).
 *
 * Height 0 is considered to be a building as well.
 *
 * At the end, the "skyline" when viewed from all four directions of the grid,
 *
 * i.e. top, bottom, left, and right, must be the same as the skyline of the original grid.
 *
 * A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance.
 *
 * See the following example.
 *
 * What is the maximum total sum that the height of the buildings can be increased?
 *
 * Example:
 * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * Output: 35
 * Explanation:
 * The grid is:
 * [ [3, 0, 8, 4],
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 * The skyline viewed from top or bottom is: [9, 4, 8, 7]
 * The skyline viewed from left or right is: [8, 7, 9, 3]
 *
 * The grid after increasing the height of buildings without affecting skylines is:
 * gridNew =
 * [ [8, 4, 8, 7],
 * [7, 4, 7, 7],
 * [9, 4, 8, 7],
 * [3, 3, 3, 3] ]
 *
 */
public class MaxSkyline {

    /**
     * Notes:
     * 1 < grid.length = grid[0].length <= 50.
     * All heights grid[i][j] are in the range [0, 100].
     * All buildings in grid[i][j] occupy the entire grid cell:
     * that is, they are a 1 x 1 x grid[i][j]rectangular prism.
     */

    public static int maxIncreaseKeepingSkyline(int[][] grid){
        int len = grid.length;
        int[] maxRows = new int[len];
        int[] maxCols = new int[len];

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                maxRows[i] = Math.max(grid[i][j], maxRows[i]);
                maxCols[j] = Math.max(grid[i][j], maxCols[j]);
            }
        }
        int res = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                res += Math.min(maxRows[i], maxCols[j]) - grid[i][j];
            }
        }

        return res;
    }

    @Test
    public void test(){
        int[][] grid = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        Assert.assertEquals(35, MaxSkyline.maxIncreaseKeepingSkyline(grid));
    }
}
