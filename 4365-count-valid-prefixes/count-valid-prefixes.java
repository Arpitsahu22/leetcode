class Solution {
    public int countValidPrefixes(String s) {
        int res = 0;
        int ones = 0;
        int zeros = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '0') {
                zeros++;
            }
            else {
                ones++;
            }
            if(Math.abs(zeros-ones) <= 1) {
                res++;
            }
        }
        return res;
    }
}