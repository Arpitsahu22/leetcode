class Solution {
    public int countSegments(String s) {
        int count = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
            if (i < n) {
                count++;
            }
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
        }

        return count;
    }
}