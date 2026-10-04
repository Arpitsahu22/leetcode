class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n + 1];
        return solve(s, 0, 0, dp);
    }
    public boolean solve(String s, int index, int count, Boolean[][] dp) {
        if (count < 0)
            return false;

        if (index == s.length())
            return count == 0;

        if (dp[index][count] != null)
            return dp[index][count];

        char ch = s.charAt(index);

        if (ch == '(') {
            return dp[index][count] =
                solve(s, index + 1, count + 1, dp);
        }

        if (ch == ')') {
            return dp[index][count] =
                solve(s, index + 1, count - 1, dp);
        }

        return dp[index][count] = solve(s, index + 1, count + 1, dp) || solve(s, index + 1, count - 1, dp) || solve(s, index + 1, count, dp);
    }
}