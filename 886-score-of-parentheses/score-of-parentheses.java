class Solution {
    public int scoreOfParentheses(String s) {
        return solve(s, 0, s.length() - 1);
    }
    public int solve(String s, int left, int right) {
        if (right - left == 1) {
            return 1;
        }

        int count = 0;
        int start = left + 1;

        for (int i = left; i <= right; i++) {

            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {

                if (i == right) {
                    return 2 * solve(s, left + 1, right - 1);
                }
                return solve(s, left, i) + solve(s, i + 1, right);
            }
        }
        return 0;
    }
}