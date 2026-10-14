class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[m + 1][n + 1][length + 1];
        
        int[][] counts = new int[length][2];
        for (int idx = 0; idx < length; idx++) {
            int zeros = 0, ones = 0;
            String s = strs[idx];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeros++;
                else ones++;
            }
            counts[idx][0] = zeros;
            counts[idx][1] = ones;
        }
        
        for (int idx = length - 1; idx >= 0; idx--) {
            int zeros = counts[idx][0];
            int ones = counts[idx][1];
            
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int skip = dp[i][j][idx + 1];
                    
                    int take = 0;
                    if (i >= zeros && j >= ones) {
                        take = 1 + dp[i - zeros][j - ones][idx + 1];
                    }
                    
                    dp[i][j][idx] = Math.max(skip, take);
                }
            }
        }
        return dp[m][n][0];
    }
}