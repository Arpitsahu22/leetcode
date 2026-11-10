class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        while (end < n) {
            while (set.contains(nums[end])) {
                set.remove(nums[start]);
                sum = sum - nums[start];
                start++;
            }
            set.add(nums[end]);
            sum = sum + nums[end];
            max = Math.max(max, sum);
            end++;
        }
        return max;
    }
}