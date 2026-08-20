class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(candidates, target, 0, curr, ans);

        return ans;
    }

    public void solve(int[] nums, int target, int start, List<Integer> curr, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for( int i = start; i < nums.length; i++){

        if (i > start && nums[i] == nums[i -1]) {
            continue;
        }
        if (nums[i] > target) break;

            curr.add(nums[i]);

            solve(nums, target - nums[i], i + 1, curr, ans);

            curr.remove(curr.size() - 1);
        }
       /* int next = i + 1;

        while (next < candidates.length &&
               candidates[next] == candidates[i]) {
            next++;
        }
        solve(candidates, target, next, curr, ans);*/
    }
}