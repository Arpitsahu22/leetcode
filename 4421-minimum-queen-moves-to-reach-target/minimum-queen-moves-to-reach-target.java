class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        if (source[0] == target[0] && source[1] == target[1])
            return 0;
        if (source[0] == target[0] || source[1] == target[1]
                || Math.abs(source[0] - target[0]) == Math.abs(source[1] - target[1]))
            return 1;
        return 2;
    }
}