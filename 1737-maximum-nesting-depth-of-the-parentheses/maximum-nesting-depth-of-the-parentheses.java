/*
class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int depth = 0;
            for (int j = 0; j <= i; j++) {
                char ch = s.charAt(j);
                if (ch == '(') {
                    depth++;
                } else if (ch == ')') {
                    depth--;
                }
            }
            ans = Math.max(ans, depth);
        }
        return ans;
    }
}
*/
class Solution {
    public int maxDepth(String s) {
        int depth = 0, maxDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                if (depth > maxDepth) maxDepth = depth;
            } else if (c == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
}