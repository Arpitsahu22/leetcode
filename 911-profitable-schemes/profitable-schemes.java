class Solution {
    int mod = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
       int [][][] dp = new int[group.length][n + 1][minProfit + 1];
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j <= n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, n, 0, group, profit, minProfit,dp);
    }
    int solve(int i, int people, int earned, int[] group, int[] profit, int minProfit, int dp[][][]) {
        if (i == group.length) {
            if (earned >= minProfit) return 1;
            return 0;
        }
        if (dp[i][people][earned] != -1) {
            return dp[i][people][earned];
        }
        int take = 0;
        if (group[i] <= people) {
            take = solve(i + 1, people - group[i],Math.min(minProfit,earned + profit[i]), group, profit, minProfit,dp);
        }
        int skip = solve(i + 1, people, earned, group, profit, minProfit,dp);
        return  dp[i][people][earned] =(take + skip) % mod;
    }
}