class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        solve(ans, s, 0, "");
        return ans;
    }
    public void solve(List<String> ans, String s, int i, String curr ) {
        if(i >= s.length()) {
            ans.add(curr);
            return;
        }
        if (Character.isLetter(s.charAt(i))) {
            solve(ans, s, i + 1, curr + Character.toLowerCase(s.charAt(i)));

            solve(ans, s, i + 1, curr + Character.toUpperCase(s.charAt(i)));

        } else {
            solve(ans, s, i + 1, curr + s.charAt(i));
        }
    }
}