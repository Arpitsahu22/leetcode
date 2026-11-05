class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int countZero = 0;
        int max = 0;
        while (end < n) {
            if (nums[end] == 0) {
                countZero++;
            }
            while (countZero > k) {
                if (nums[start] == 0) {
                    countZero--;
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}