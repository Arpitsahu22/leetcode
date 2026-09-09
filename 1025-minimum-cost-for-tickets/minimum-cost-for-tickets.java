// Recursion
/*
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return solve(days, costs, 0);
    }
    public int solve(int[] days, int[] costs, int i) {
        if(i >= days.length) return 0;
        int od = costs[0] + solve(days, costs, i+1);
        int j = i;
        while(j < days.length && days[j]< days[i] + 7) {
            j++;
        }
        int sd = costs[1] + solve(days, costs, j);
        while(j < days.length && days[j]< days[i] + 30) {
            j++;
        }
        int td = costs[2] + solve(days, costs, j);
        return Math.min(od, Math.min(sd, td));
    }
}
*/
// Memoization
/*
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return solve(days, costs, 0, dp);
    }
    public int solve(int[] days, int[] costs, int i, int[] dp) {
        if (i >= days.length) return 0;
        if (dp[i] != -1) return dp[i];
        int od = costs[0] + solve(days, costs, i + 1, dp);
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        int sd = costs[1] + solve(days, costs, j, dp);
        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        int td = costs[2] + solve(days, costs, j, dp);
        dp[i] = Math.min(od, Math.min(sd, td));
        return dp[i];
    }
}
*/
// Tabulation
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int od = costs[0] + dp[i + 1];
            int j = i;
            while (j < n && days[j] < days[i] + 7) {
                j++;
            }
            int sd = costs[1] + dp[j];
            j = i;
            while (j < n && days[j] < days[i] + 30) {
                j++;
            }
            int td = costs[2] + dp[j];
            dp[i] = Math.min(od, Math.min(sd, td));
        }
        return dp[0];
    }
}