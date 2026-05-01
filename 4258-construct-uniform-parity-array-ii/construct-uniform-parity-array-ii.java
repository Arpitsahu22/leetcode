class Solution {
    public boolean uniformArray(int[] nums1) {
        int mn = Integer.MAX_VALUE;

        for (int x : nums1) {
            mn = Math.min(mn, x);
        }

        if (mn % 2 == 1) return true;

        for (int x : nums1) {
            if (x % 2 == 1) return false;
        }

        return true;
    }
}