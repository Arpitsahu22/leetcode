class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = solve(0, target, nums, dp);

        if (ans < 0)
            return -1;

        return ans;
    }

    public int solve(int i, int target, List<Integer> nums, int[][] dp) {

        if (target == 0)
            return 0;

        if (i == nums.size())
            return Integer.MIN_VALUE;

        if (dp[i][target] != -1)
            return dp[i][target];
            
        int skip = solve(i + 1, target, nums, dp);
        int take = Integer.MIN_VALUE;

        if (nums.get(i) <= target) {
            take = 1 + solve(i + 1, target - nums.get(i), nums, dp);
        }

        return dp[i][target] = Math.max(take, skip);
    }
}