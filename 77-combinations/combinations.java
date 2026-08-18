class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(ans, n, k, 1, curr);

        return ans;
    }

    public void solve(List<List<Integer>> ans, int n, int k,
                      int i, List<Integer> curr) {

        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (i > n) {
            return;
        }

        // Take call
        curr.add(i);
        solve(ans, n, k, i + 1, curr);

        // Backtrack
        curr.remove(curr.size() - 1);

        // Skip call
        solve(ans, n, k, i + 1, curr);
    }
}