class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }
    public int solve(int[] nums, int target, int i, int currSum) {
        if (i == nums.length) {
            return currSum == target ? 1 : 0;
        }
        int take = solve(nums, target, i + 1, currSum + nums[i]);
        int skip = solve(nums, target, i + 1, currSum - nums[i]);
        return take + skip;
    }
}