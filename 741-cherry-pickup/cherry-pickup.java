class Solution {
    int[][][] dp;
    int n;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new int[n][n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = solve(grid, 0, 0, 0);
        return Math.max(0, ans);
    }
    public int solve(int[][] grid, int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n)
            return Integer.MIN_VALUE;
        if(grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if(r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];
        if(dp[r1][c1][r2] != -1)
            return dp[r1][c1][r2];

        int cherries = grid[r1][c1];
        if(r1 != r2 || c1 != c2)
            cherries += grid[r2][c2];

        int a = solve(grid, r1 + 1, c1, r2 + 1); 
        int b = solve(grid, r1 + 1, c1, r2);     
        int c = solve(grid, r1, c1 + 1, r2 + 1); 
        int d = solve(grid, r1, c1 + 1, r2);    

        int maxNext = Math.max(Math.max(a, b), Math.max(c, d));
        return dp[r1][c1][r2] = cherries + maxNext;
    }
}