class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long s1 = 0;
        long s2 = 0;
        for (int i = 0; i < source.length; i++) {
            s1 += source[i];
            s2 += target[i];
        }
        return s1 == s2;
    }
}