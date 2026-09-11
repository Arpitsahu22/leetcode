class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        solve(ans, 0);
        return ans;
    }
    public void solve(int[] ans, int i) {
        if (i > ans.length - 1) return;
        ans[i] = countOnes(i);
        solve(ans, i + 1);
    }
    public int countOnes(int n) {
        if (n == 0) return 0;
        return (n % 2) + countOnes(n / 2);
    }
}