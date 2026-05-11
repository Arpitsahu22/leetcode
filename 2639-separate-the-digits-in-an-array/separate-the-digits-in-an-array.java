class Solution {
    public int[] separateDigits(int[] nums) {
        int total = 0;

        for (int num : nums) {
            int temp = num;

            while (temp > 0) {
                total++;
                temp /= 10;
            }
        }

        int[] ans = new int[total];
        int idx = total - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            int num = nums[i];

            while (num > 0) {
                ans[idx--] = num % 10;
                num /= 10;
            }
        }

        return ans;
    }
}