class Solution {
    //rec
   /* public boolean canReach(int[] arr) {
        // code here
        
        return solve(0, arr);
    }
    boolean solve(int curr, int num[]){
        if(curr == num.length - 1)return true;
        if(curr >= num.length )return false;
        for(int i = 1; i <= num[curr]; i ++){
           if( solve(curr + i,num)) return true;
        }
        return false;
    }*/
    //memo
    public boolean canJump(int[] arr) {
        int dp[]= new int[arr.length];
        Arrays.fill(dp,  -1);
        return solve(0, arr, dp);
    }
    boolean solve(int curr, int num[],int dp[]){
        if(curr == num.length - 1)return true;
        if(curr >= num.length )return false;
        if(dp[curr] != -1) return dp[curr]==1;
        for(int i = 1; i <= num[curr]; i ++){
           if( solve(curr + i,num,dp)){
               dp[curr]=1;
            return true;
           }
        }
        dp[curr]= 0;
        return false;
    }
}