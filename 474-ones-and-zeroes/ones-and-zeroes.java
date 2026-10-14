class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(strs, m, n, 0);
    }
    public int solve(String[] strs, int m, int n, int i) {
        if (i == strs.length) return 0;  
        if (dp[i][m][n] != -1) return dp[i][m][n];
        int zeros = 0, ones = 0;
        for (int j = 0; j < strs[i].length(); j++) {
            if (strs[i].charAt(j) == '0') zeros++;
            else ones++;
        }
        int take = 0;
        if (m >= zeros && n >= ones) {
            take = 1 + solve(strs, m - zeros, n - ones, i + 1);
        }
        int skip = solve(strs, m, n, i + 1);
        return dp[i][m][n] = Math.max(take, skip);
    }
}
