class Solution {
    public int mirrorFrequency(String s) { 
        int[] letterFreq = new int[26];
        int[] digitFreq = new int[10];
        
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterFreq[ch - 'a']++;
            } else {
                digitFreq[ch - '0']++;
            }
        }
        int ans = 0;
        for (int i = 0; i < 13; i++) {
            ans += Math.abs(letterFreq[i] - letterFreq[25 - i]);
        }
        for (int i = 0; i < 5; i++) {
            ans += Math.abs(digitFreq[i] - digitFreq[9 - i]);
        }
        return ans;
    }
}