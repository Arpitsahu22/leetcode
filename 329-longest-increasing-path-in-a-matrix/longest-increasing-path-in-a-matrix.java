// Recursion
/*
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, solve(matrix, i, j, m, n));
            }
        }
        return ans;
    }
    public int solve(int[][] matrix, int i, int j, int m, int n) {
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            up = solve(matrix, i - 1, j, m, n);
        }
        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j]) {
            down = solve(matrix, i + 1, j, m, n);
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            left = solve(matrix, i, j - 1, m, n);
        }
        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j]) {
            right = solve(matrix, i, j + 1, m, n);
        }
        return 1 + Math.max(Math.max(up, down), Math.max(left, right));
    }
}
*/
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, solve(matrix, i, j, m, n, dp));
            }
        }
        return ans;
    }
    public int solve(int[][] matrix, int i, int j, int m, int n, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            up = solve(matrix, i - 1, j, m, n, dp);
        }
        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j]) {
            down = solve(matrix, i + 1, j, m, n, dp);
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            left = solve(matrix, i, j - 1, m, n, dp);
        }
        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j]) {
            right = solve(matrix, i, j + 1, m, n, dp);
        }
        dp[i][j] = 1 + Math.max(Math.max(up, down), Math.max(left, right));
        return dp[i][j];
    }
}