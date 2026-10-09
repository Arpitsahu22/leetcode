class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (int stone : stones) {
            sum += stone;
        }

        int[][] dp = new int[stones.length][2 * sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(stones, 0, 0, sum, dp);
    }

    public int solve(int[] stones, int i, int curr, int sum, int[][] dp) {

        if (i == stones.length) {
            return Math.abs(curr);
        }

        if (dp[i][curr + sum] != -1) {
            return dp[i][curr + sum];
        }

        int take = solve(stones, i + 1, curr + stones[i], sum, dp);

        int skip = solve(stones, i + 1, curr - stones[i], sum, dp);

        return dp[i][curr + sum] = Math.min(take, skip);
    }
}