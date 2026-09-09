// Recursion
/*
class Solution {
    public long mostPoints(int[][] questions) {
        return solve(questions, 0);
    }
    public long solve(int[][] questions, int i) {
        if (i >= questions.length) return 0;
        long take = questions[i][0] + solve(questions, i + questions[i][1] + 1);
        long skip = solve(questions, i + 1);
        return Math.max(take, skip);
    }
}
*/
// Memoization
class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return solve(questions, 0, dp);
    }
    public long solve(int[][] questions, int i, long[] dp) {
        if (i >= questions.length) return 0;
        if (dp[i] != -1) return dp[i];
        long take = questions[i][0] + solve(questions, i + questions[i][1] + 1, dp);
        long skip = solve(questions, i + 1, dp);
        dp[i] = Math.max(take, skip);
        return dp[i];
    }
}