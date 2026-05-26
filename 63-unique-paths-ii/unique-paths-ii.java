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

        return solve(0, 0, obstacleGrid, dp);
    }

    public int solve(int i, int j, int[][] grid, int[][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n) {
            return 0;
        }
        if (grid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = solve(i + 1, j, grid, dp);

        int right = solve(i, j + 1, grid, dp);

        dp[i][j] = down + right;

        return dp[i][j];
    }
}