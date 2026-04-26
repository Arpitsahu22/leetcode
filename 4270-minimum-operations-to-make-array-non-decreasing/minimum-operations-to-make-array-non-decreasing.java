class Solution {
    public long minOperations(int[] nums) {
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                ans += nums[i] - nums[i + 1];
            }
        }
        return ans;
    }
}