class Solution {
    int mod = 1000000007;
    int[][] dp;

    public int numberOfWays(int n, int x) {
        dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(1, n, x);
    }
    public int solve(int n, int sum, int x) {

        if (sum == 0)
            return 1;

        if (n > sum)
            return 0;

        if (dp[n][sum] != -1)
            return dp[n][sum];

        int power = (int) Math.pow(n, x);

        if (power > sum)
            return 0;

        int take = solve(n + 1, sum - power, x);

        int notTake = solve(n + 1, sum, x);

        return dp[n][sum] = (take + notTake) % mod;
    }
}