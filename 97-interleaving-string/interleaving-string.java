class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;
        Boolean dp[][] = new Boolean[n + 1][m + 1];
        return solve(0, 0, s1, s2, s3, dp);
    }
    public boolean solve(int i, int j, String s1, String s2,String s3, Boolean dp[][]) {
        int n = s1.length();
        int m = s2.length();
        if (i == n && j == m) return true;
        if (dp[i][j] != null) return dp[i][j];
        int k = i + j;
        boolean first = false;
        boolean second = false;
        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            first = solve(i + 1, j, s1, s2, s3, dp);
        }
        if (j < m && s2.charAt(j) == s3.charAt(k)) {
            second = solve(i, j + 1, s1, s2, s3, dp);
        }
        return dp[i][j] = first || second;
    }
}
