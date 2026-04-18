class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (String s : sentences) {
            int count = 1; 
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    count++;
                }
            }
            maxWords = Math.max(maxWords, count);
        }
        return maxWords;
    }
}