// Brute force
/*class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}*/

// Tabulation
/*class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}*/
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp [] = new int[n];
        Arrays.fill(dp, -1);
        int ans = nums[0];

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(i, nums, dp));
        }
        return ans;
    }
    int solve(int i, int[] nums, int dp []) {
        if (i == 0) return nums[0];

        if (dp[i] != -1) return dp[i];
        int take = nums[i] + solve(i - 1, nums, dp);
        int start = nums[i];
        
        return dp[i] = Math.max(take, start);
    }
}

