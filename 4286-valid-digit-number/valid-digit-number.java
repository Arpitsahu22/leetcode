class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        char ch = (char)(x + '0');

        boolean found = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                found = true;
                break;
            }
        }
        return found && s.charAt(0) != ch;
    }
}