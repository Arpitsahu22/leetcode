class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][][] dp = new long[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = Long.MIN_VALUE;
                dp[i][j][1] = Long.MAX_VALUE;
            }
        }

        long[] ans = solve(0, 0, grid, dp);

        if (ans[0] < 0) {
            return -1;
        }

        return (int)(ans[0] % 1000000007);
    }

    public long[] solve(int r, int c, int[][] grid, long[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (r == m - 1 && c == n - 1) {
            return new long[]{grid[r][c], grid[r][c]};
        }
        if (dp[r][c][0] != Long.MIN_VALUE) {
            return new long[]{dp[r][c][0], dp[r][c][1]};
        }

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        if (r + 1 < m) {
            long[] down = solve(r + 1, c, grid, dp);

            max = Math.max(max, grid[r][c] * down[0]);
            max = Math.max(max, grid[r][c] * down[1]);

            min = Math.min(min, grid[r][c] * down[0]);
            min = Math.min(min, grid[r][c] * down[1]);
        }

        if (c + 1 < n) {
            long[] right = solve(r, c + 1, grid, dp);

            max = Math.max(max, grid[r][c] * right[0]);
            max = Math.max(max, grid[r][c] * right[1]);

            min = Math.min(min, grid[r][c] * right[0]);
            min = Math.min(min, grid[r][c] * right[1]);
        }

        dp[r][c][0] = max;
        dp[r][c][1] = min;

        return new long[]{max, min};
    }
}