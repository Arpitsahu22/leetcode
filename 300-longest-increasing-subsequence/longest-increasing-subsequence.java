class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int l = 0;
            int h = ans.size();
            while (l < h) {
                int mid = l + (h - l) / 2;
                if (ans.get(mid) < nums[i]) {
                    l = mid + 1;
                }
                else {
                    h = mid;
                }
            }
            if (l == ans.size()) {
                ans.add(nums[i]);
            }
            else {
                ans.set(l, nums[i]);
            }
        }
        return ans.size();
    }
}
