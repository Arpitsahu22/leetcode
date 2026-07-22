class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {

            int skip = 0;
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skip++;
                    i--;
                } else if (skip > 0) {
                    skip--;
                    i--;
                } else {
                    break;
                }
            }

            skip = 0;
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skip++;
                    j--;
                } else if (skip > 0) {
                    skip--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j))
                    return false;
            } else if (i >= 0 || j >= 0) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}