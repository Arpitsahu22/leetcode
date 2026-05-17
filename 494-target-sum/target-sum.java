class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0, 0);
    }

    private int backtrack(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        
        int add = backtrack(nums, target, index + 1, currentSum + nums[index]);

      
        int subtract = backtrack(nums, target, index + 1, currentSum - nums[index]);

        
        return add + subtract;
    }
}