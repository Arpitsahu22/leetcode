// Recursion
/*
class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            ans = Math.min(ans, solve(0, c, m, n, grid, moveCost));
        }
        return ans;
    }
    public int solve(int r, int c, int m, int n, int[][] grid, int[][] moveCost) {
        if (r == m - 1) return grid[r][c];
         int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int cost = grid[r][c] + moveCost[grid[r][c]][j] + solve(r + 1, j,m,n,grid,moveCost);
            ans = Math.min(ans, cost);
        }
        return ans;
    }
}
*/
// Memoization
class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            ans = Math.min(ans, solve(0, c, m, n, grid, moveCost, dp));
        }
        return ans;
    }
    public int solve(int r, int c, int m, int n, int[][] grid, int[][] moveCost, int[][] dp) {
        if (r == m - 1) return grid[r][c];
        if (dp[r][c] != -1) return dp[r][c];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int cost = grid[r][c] + moveCost[grid[r][c]][j] + solve(r + 1, j, m, n, grid, moveCost, dp);
            ans = Math.min(ans, cost);
        }
        return dp[r][c] = ans;
    }
}

