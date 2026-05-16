class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);   
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        Set<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {

            if (used.contains(nums[i])) continue;
            used.add(nums[i]);

            swap(nums, index, i);
            backtrack(nums, index + 1, result);
            swap(nums, index, i); 
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}