class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public int atMost(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int count = 0;
        int ans = 0;
        while (end < n) {
            if (nums[end] % 2 != 0) {
                count++;
            }
            while (count > k) {
                if (nums[start] % 2 != 0) {
                    count--;
                }
                start++;
            }
            ans += end - start + 1;
            end++;
        }
        return ans;
    }
}
