class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return solve(grid, 0, 0, n - 1, dp);
    }

    public int solve(int[][] grid, int row, int col1, int col2, int[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (col1 < 0 || col1 >= n || col2 < 0 || col2 >= n)
            return Integer.MIN_VALUE;

        if (row == m - 1) {
            if (col1 == col2)
                return grid[row][col1];

            return grid[row][col1] + grid[row][col2];
        }

        if (dp[row][col1][col2] != Integer.MIN_VALUE)
            return dp[row][col1][col2];

        int ans = Integer.MIN_VALUE;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                int curr = grid[row][col1];

                if (col1 != col2)
                    curr += grid[row][col2];

                curr += solve(grid, row + 1, col1 + i, col2 + j, dp);

                ans = Math.max(ans, curr);
            }
        }

        return dp[row][col1][col2] = ans;
    }
}