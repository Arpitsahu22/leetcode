class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);

        solve(ans, nums, 0, curr);

        return ans;
    }

    public void solve(List<List<Integer>> ans, int[] nums, int i,
                      List<Integer> curr) {

        if (i >= nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Take call
        curr.add(nums[i]);
        solve(ans, nums, i + 1, curr);

        // Backtrack
        curr.remove(curr.size() - 1);

        // Skip duplicate elements
        int j = i + 1;

        while (j < nums.length && nums[j] == nums[i]) {
            j++;
        }

        // Skip call
        solve(ans, nums, j, curr);
    }
}