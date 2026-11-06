class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < n) {
            char ch = s.charAt(end);
            while (set.contains(ch)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(ch);
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}