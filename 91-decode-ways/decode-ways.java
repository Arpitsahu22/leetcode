// Recursion
/*class Solution {
    public int numDecodings(String s) {
        return solve(0, s);
    }
    int solve(int i, String s) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        int one = solve(i + 1, s);
        int two = 0;
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) two = solve(i + 2, s);
        }
        return one + two;
    }
}*/

class Solution {
    public int numDecodings(String s) {
        int dp [] = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }
    int solve(int i, String s, int dp []) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != -1) return dp[i];
        int one = solve(i + 1, s, dp);
        int two = 0;
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                two = solve(i + 2, s, dp);
            }
        }
        return dp[i] = one + two;
    }
}