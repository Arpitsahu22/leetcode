class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median=nums[nums.length/2];
        int opp=0;
        for(int a:nums){
            opp+=Math.abs(median-a);
        }
        return opp;
    }
}