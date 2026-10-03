// Recursion
/*
class Solution {
    public int solve(int[][] matrix,int row, int col, int i, int j){
        if( j < 0|| j >= col) return 100000;
        if( i == row - 1) return matrix[i][j];
       int below  = matrix[i][j] + solve(matrix,row, col,i + 1, j);
        int diag_left = matrix[i][j] +solve(matrix, row , col,i + 1,j - 1);
        int diag_right = matrix[i][j] + solve(matrix, row,col, i + 1, j + 1);
        return Math.min(below ,Math.min(diag_left, diag_right));
    }
     public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < m;j++){
          ans = Math.min(ans, solve(matrix, n, m, 0, j));
      }
      return ans;
    }
}
*/
// Memoization
class Solution {

    int[][] dp;

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, solve(0, j, matrix));
        }

        return ans;
    }

    public int solve(int r, int c, int[][] matrix) {

        int n = matrix.length;

        // last row
        if (r == n - 1) {
            return matrix[r][c];
        }

        // already calculated
        if (dp[r][c] != Integer.MAX_VALUE) {
            return dp[r][c];
        }

        int down = solve(r + 1, c, matrix);

        int left = Integer.MAX_VALUE;
        if (c > 0) {
            left = solve(r + 1, c - 1, matrix);
        }

        int right = Integer.MAX_VALUE;
        if (c + 1 < n) {
            right = solve(r + 1, c + 1, matrix);
        }

        dp[r][c] = matrix[r][c] + Math.min(down, Math.min(left, right));

        return dp[r][c];
    }
}