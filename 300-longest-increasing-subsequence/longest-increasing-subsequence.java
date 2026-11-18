class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                   ans[i] = Math.max(ans[i], 1 + ans[j]);
                }
            }
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}