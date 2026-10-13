class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i[] : dp) {
            Arrays.fill(i,-1);
        }
        return solve(coins, amount, 0, dp);
    }
    public int solve(int[] coins, int amount, int i, int dp[][]) {
        if (amount == 0) return 1;
        if (i == coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int take = 0;
        if (coins[i] <= amount) {
            take = solve(coins, amount - coins[i], i, dp);
        }
        int skip = solve(coins, amount, i + 1, dp);

        return dp[i][amount] = take + skip;
    }
}