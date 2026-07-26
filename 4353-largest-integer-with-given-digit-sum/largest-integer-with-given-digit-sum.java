class Solution {
    public int largestInteger(int n, int s) {
        if(s == 0) return 0;
        if(n*9 < s) return -1;
        int ans = 0;
        for(int i = 1;i <= n;i++){
            if(s >= 9){
                ans += 9;
                s -= 9;
            }
            else{
                ans += s;
                s = 0;
            }
            if(i == n) continue;
            ans *= 10;
        }
        return ans;
    }
}