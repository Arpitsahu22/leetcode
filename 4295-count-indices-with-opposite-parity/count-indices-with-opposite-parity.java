class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n=nums.length;
        int e=0;
        int od=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) e++;
            else od++;
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) e--;
            else od--;
            if(nums[i]%2==0) res[i]=od;
            else res[i]=e;
        }
        return res;
    }
}