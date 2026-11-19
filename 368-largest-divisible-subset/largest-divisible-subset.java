class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans[] = new int[n];
        int prev[] = new int[n];
        int max = 0;
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (ans[j] + 1 > ans[i]) {
                        ans[i] = ans[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (ans[i] > max) {
                max = ans[i];
                lastIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (lastIndex != -1) {
            res.add(nums[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        return res;
    }
}
