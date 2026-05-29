class Solution {
    public int minElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        int firstNum = nums[0];
        int ans = 0;
        while (firstNum > 0) {
            ans += (firstNum % 10);
            firstNum /= 10;
        }
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int currentSum = 0;

            while (num > 0) {
                currentSum += (num % 10);
                num /= 10;
            }
            if (currentSum < ans) {
                ans = currentSum;
            }
        }

        return ans;
    }
}