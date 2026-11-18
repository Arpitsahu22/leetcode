class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int prevElement = i - 1; prevElement >= -1; prevElement--) {
                int skip = dp[i + 1][prevElement + 1];
                int take = 0;
                if (prevElement == -1 || nums[i] > nums[prevElement]) {
                    take = 1 + dp[i + 1][i + 1];
                }
                dp[i][prevElement + 1] = Math.max(take, skip);
            }
        }
        return dp[0][0];
    }
}