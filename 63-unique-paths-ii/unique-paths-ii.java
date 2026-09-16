// Recursion
/*
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return solve(0, 0, m, n, obstacleGrid);
    }
    public int solve(int row, int col, int m, int n, int[][] obstacleGrid) {
        if (row >= m || col >= n) return 0;
        if (obstacleGrid[row][col] == 1) return 0;
        if (row == m - 1 && col == n - 1) return 1;
        int down = solve(row + 1, col, m, n, obstacleGrid);
        int right = solve(row, col + 1, m, n, obstacleGrid);
        return down + right;
    }
}
*/
// Memoization

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, m, n, obstacleGrid, dp);
    }
    public int solve(int r, int c, int m, int n, int[][] grid, int[][] dp) {
        if (r >= m || c >= n) return 0;
        if (grid[r][c] == 1) return 0;
        if (r == m - 1 && c == n - 1) return 1;
        if (dp[r][c] != -1) return dp[r][c];
        int down = solve(r + 1, c, m, n, grid, dp);
        int right = solve(r, c + 1, m, n, grid, dp);
        dp[r][c] = down + right;
        return dp[r][c];
    }
}

//Tabulation
/*
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    }
}
*/
