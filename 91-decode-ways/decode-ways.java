class Solution {
    public int numDecodings(String s) {
        int dp [] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp, -1);
        }
        return solve(0, s, dp);
    }
    public int solve(int i, String s, int dp []) {
        if (i >= s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != -1) return dp[i];
        int single = solve(i + 1, s, dp);
        int twoNumber = 0;
        if (i < s.length() - 1) {
            int curr = s.charAt(i) - 48;
            int next = s.charAt(i + 1) - 48;
            int num = curr * 10 + next;
            if (num <= 26) twoNumber = solve(i + 2, s, dp);
        }
        dp[i] = single + twoNumber;
        return dp[i];
    }
}