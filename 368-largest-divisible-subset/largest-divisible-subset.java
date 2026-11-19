class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans[] = new int[n];
        int prev[] = new int[n];
        int maxlen = 0;
        int parent = 0;
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
            if (ans[i] > maxlen) {
                maxlen = ans[i];
                parent = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (parent != -1) {
            res.add(nums[parent]);
            parent = prev[parent];
        }
        return res;
    }
}
