// Recursive
/*
class Solution {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return solve(m, n, maxMove, startRow, startColumn);
    }
    public int solve(int m, int n, int moves, int r, int c) {

        if (r < 0 || r >= m || c < 0 || c >= n) return 1;
        if (moves == 0) return 0;
        int up = solve(m, n, moves - 1, r - 1, c);
        int down = solve(m, n, moves - 1, r + 1, c);
        int left = solve(m, n, moves - 1, r, c - 1);
        int right = solve(m, n, moves - 1, r, c + 1);
        return (int) (((long) up + down + left + right) % mod);
    }
}
*/
// Memoization
class Solution {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int [][][] dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(m, n, maxMove, startRow, startColumn, dp);
    }
    public int solve(int m, int n, int moves, int r, int c, int [][][] dp) {
        if (r < 0 || r >= m || c < 0 || c >= n) return 1;
        if (moves == 0) return 0;
        if (dp[r][c][moves] != -1) return dp[r][c][moves];
        int up = solve(m, n, moves - 1, r - 1, c, dp);
        int down = solve(m, n, moves - 1, r + 1, c, dp);
        int left = solve(m, n, moves - 1, r, c - 1, dp);
        int right = solve(m, n, moves - 1, r, c + 1, dp);
        dp[r][c][moves] = (int) (((long) up + down + left + right) % mod);
        return dp[r][c][moves];
    }
}
