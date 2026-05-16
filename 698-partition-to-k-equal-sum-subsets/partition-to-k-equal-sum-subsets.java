class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % k != 0) {
            return false;
        }

        int target = totalSum / k;
        Arrays.sort(nums);
        reverse(nums);

        if (nums[0] > target) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] used, int k,
                              int start, int currentSum, int target) {

        if (k == 1) {
            return true;
        }
        if (currentSum == target) {
            return backtrack(nums, used, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (currentSum + nums[i] > target) {
                continue;
            }

            used[i] = true;

            if (backtrack(nums, used, k, i + 1, currentSum + nums[i], target)) {
                return true;
            }

            used[i] = false;
            if (currentSum == 0) {
                return false;
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return false;
    }
    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}