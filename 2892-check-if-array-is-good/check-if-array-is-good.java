class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        if(n < 2) return false;

        int k = n - 1;
        int []count = new int[n];

        for(int num : nums) {
            if(num > k || num < 1) {
                return false;
            }
            count[num]++;
        }
        for(int i=1; i<k; i++) {
            if(count[i] != 1) return false;
        }
        return count[k] == 2;
    }
}