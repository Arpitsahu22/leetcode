// Recursion
/*
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(0, 0, m, n, grid);
    }
    public int solve(int r, int c, int m, int n, int grid[][]) {
        if (r == m - 1 && c == n - 1) return grid[r][c];
        if (r >= m || c >= n) return Integer.MAX_VALUE;
        int down = solve(r + 1, c, m, n, grid);
        int right = solve(r, c + 1, m, n, grid);
        return grid[r][c] + Math.min(down, right);
    }
}
*/
// Memoization

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, m, n, grid, dp);
    }
    public int solve(int r, int c, int m, int n, int grid[][], int dp[][]) {
        if (r == m - 1 && c == n - 1) return grid[r][c];
        if (r >= m || c >= n) return Integer.MAX_VALUE;
        if (dp[r][c] != -1) return dp[r][c];
        int down = solve(r + 1, c, m, n, grid, dp);
        int right = solve(r, c + 1, m, n, grid, dp);
        return dp[r][c] = grid[r][c] + Math.min(down, right);
    }
}















// Brute force
/*
class Solution {
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j)
        if (i > 0 && j > 0)
          grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        else if (i > 0)
          grid[i][0] += grid[i - 1][0];
        else if (j > 0)
          grid[0][j] += grid[0][j - 1];

    return grid[m - 1][n - 1];
  }
}
*/