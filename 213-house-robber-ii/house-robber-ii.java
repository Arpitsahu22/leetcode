// Recursion 
/*
 class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int first = solve(nums, 0, n - 2);
        int last = solve(nums, 1, n - 1);
        return Math.max(first, last);
    }

    int solve(int[] nums, int i, int n) {
        if (i > n) return 0;
        int take = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);
        return Math.max(take, skip);
    }
}
*/
// Memoization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int first = solve(nums, 0, n - 2, dp);
        Arrays.fill(dp, -1);
        int last = solve(nums, 1, n - 1, dp);
        return Math.max(first, last);
    }
    int solve(int[] nums, int i, int end, int[] dp) {
        if (i > end) return 0;
        if (dp[i] != -1) return dp[i];
        int take = nums[i] + solve(nums, i + 2, end, dp);
        int skip = solve(nums, i + 1, end, dp);

        return dp[i] = Math.max(take, skip);
    }
}