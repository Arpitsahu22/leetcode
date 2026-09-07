//memoization
class Solution {
    public int jump(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }
    public int solve(int[] nums, int i , int dp[]) {
        if (i >= nums.length - 1) return 0;
        if(dp[i] != -1) return dp[i];

        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
            if (i + j < nums.length) {
                int jumps = solve(nums, i + j, dp);
                if (jumps != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + jumps);
                }
            }
        }
        return dp[i] = ans;
    }
}