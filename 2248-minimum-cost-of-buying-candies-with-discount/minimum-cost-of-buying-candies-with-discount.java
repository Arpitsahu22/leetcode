class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int ans = 0;
        int idx = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            if (idx % 3 != 2) {
                ans += cost[i];
            }
            idx++;
        }

        return ans;
    }
}