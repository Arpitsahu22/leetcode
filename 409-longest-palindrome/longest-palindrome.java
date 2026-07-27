class Solution {
    public int longestPalindrome(String s) {

        boolean[] visited = new boolean[s.length()];

        int length = 0;
        boolean oddFound = false;

        for (int i = 0; i < s.length(); i++) {

            if (visited[i]) {
                continue;
            }

            int count = 0;
            for (int j = 0; j < s.length(); j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                    visited[j] = true;
                }
            }
            if (count % 2 == 0) {
                length += count;
            }
            else {
                length += count - 1;
                oddFound = true;
            }
        }
        if (oddFound) {
            length += 1;
        }

        return length;
    }
}