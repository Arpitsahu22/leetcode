class Solution {
    int dp [][];
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        dp = new int [m+1][n+1];
        for( int []curr : dp) {
            Arrays.fill(curr,-1);
        }

        return 1 - solve(dungeon, m, n, 0, 0);
    }
    public int solve(int[][] dungeon, int m, int n, int row, int col) {
        if (row >= m || col >= n) return Integer.MIN_VALUE;
        if (row == m - 1 && col == n - 1) return Math.min(0, dungeon[row][col]);
        if(dp[row][col] != -1) return dp[row][col];
        int right = solve(dungeon, m, n, row, col + 1);
        int down = solve(dungeon, m, n, row + 1, col);
        int best = Math.max(right, down);
        return dp[row][col] = Math.min(0, dungeon[row][col] + best);
    }
}