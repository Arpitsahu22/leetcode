class Solution {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n = s.length();
        int m = word1.length();
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2;
                    if (j > i + 1) {
                        dp[i][j] += dp[i + 1][j - 1];
                    }
                    if (i < m && j >= m) {
                        ans = Math.max(ans, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return ans;
    }
}