class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, -1, nums, n, dp);
    }
    public int solve(int i, int prevElement, int[] nums, int n, int[][] dp) {
        if (i >= n) return 0;
        if (dp[i][prevElement + 1] != -1) return dp[i][prevElement + 1];
        int skip = solve(i + 1, prevElement, nums, n, dp);
        int take = 0;
        if (prevElement == -1 || nums[i] > nums[prevElement]) {
            take = 1 + solve(i + 1, i, nums, n, dp);
        }
        return dp[i][prevElement + 1] = Math.max(take, skip);
    }
}