class Solution {
    public boolean rotateString(String s, String goal) {
        int str1 = s.length();
        int str2 = goal.length();

        if (str1 != str2) {
            return false;
        }

        for (int i = 0; i < str1; i++) {
            s = s.substring(1) + s.charAt(0);

            if (s.equals(goal)) {
                return true;
            }
        }

        return false;
    }
}