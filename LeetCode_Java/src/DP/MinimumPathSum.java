package DP;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1¡ú3¡ú1¡ú1¡ú1 minimizes the sum.
 */
public class MinimumPathSum {
	//in place, use the original matrix
	public int minPathSum(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (r == 0 && c == 0) {
                    continue;
                } else if (c == 0) {
                    grid[r][c] += grid[r - 1][c];
                } else if (r == 0) {
                    grid[r][c] += grid[r][c - 1];
                } else {
                    grid[r][c] += Math.min(grid[r - 1][c] , grid[r][c - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
