class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int [][]dp = new int[rewardValues.length][4000];

        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return solve(rewardValues, 0, 0, dp);
    }
    public int solve(int[] arr, int i, int sum, int dp[][]) {
        if (i == arr.length) return sum;
        if (dp[i][sum] != -1) return dp[i][sum];
        int take = 0;
        if (arr[i] > sum) {
            take = solve(arr, i + 1, sum + arr[i], dp);
        }
        int skip = solve(arr, i + 1, sum, dp);
        return dp[i][sum] = Math.max(take, skip);
    }
}