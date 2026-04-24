class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int L = 0, R = 0, underscore = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'L') {
                L++;
            } else if (ch == 'R') {
                R++;
            } else {
                underscore++;
            }
        }
        return Math.abs(L - R) + underscore;
    }
}