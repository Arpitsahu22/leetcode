class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve(ans, n, 0, 0, "");

        return ans;
    }

    public void solve(List<String> ans, int n, int open, int close, String curr) {

        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }
        if (open < n) {
            solve(ans, n, open + 1, close, curr + "(");
        }
        if (close < open) {
            solve(ans, n, open, close + 1, curr + ")");
        }
    }
}