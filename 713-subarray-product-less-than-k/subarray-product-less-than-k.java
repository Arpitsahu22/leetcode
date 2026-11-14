class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        int e = 0;
        int product = 1;
        int ans = 0;
        if (k <= 1) return 0;
        while (e < n) {
            product *= nums[e];
            while (product >= k) {
                product /= nums[s];
                s++;
            }
            ans += e - s + 1;
            e++;
        }
        return ans;
    }
}
