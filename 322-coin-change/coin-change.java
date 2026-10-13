class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = solve(coins, amount, 0, dp);
        if (ans >= 1000000) return -1;
        return ans;
    }
    public int solve(int[] coins, int amount, int i, int[][] dp) {
        if (amount == 0) return 0;
        if (i == coins.length) return 1000000;
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int skip = solve(coins, amount, i + 1, dp);
        int take = 1000000;
        if (coins[i] <= amount) {
            take = 1 + solve(coins, amount - coins[i], i, dp);
        }
        return dp[i][amount] = Math.min(take, skip);
    }
}