// Recursion
/*
class Solution {
    public int uniquePaths(int m, int n) {
        return solve(0, 0, m, n);
    }
    public int solve(int r, int c, int m, int n) {
        if (r == m - 1 || c == n - 1) return 1;
        int down = solve(r + 1, c, m, n);
        int right = solve(r, c + 1, m, n);
        return down + right;
    }
}
*/
// Memoization 
/*
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, m, n, dp);
    }
    public int solve(int row, int col, int m, int n, int dp[][]) {
        if (row == m - 1 || col == n - 1) return 1;
        if (row >= m || col >= n) return 0;
        if (dp[row][col] != -1) return dp[row][col];
        int down = solve(row + 1, col, m, n, dp);
        int right = solve(row, col + 1, m, n, dp);
        return dp[row][col] = down + right;
    }
}
*/
// Tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                int down = dp[i][j+1] ;
                int right = dp[i+1][j];
                dp[i][j] = down + right;
            }
        }
        return dp[0][0];
    }
}