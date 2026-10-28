class Solution {
    int min=Integer.MAX_VALUE;
    int n,m;
    int[][]grid;
    Boolean[][][]dp;
    public int minCost(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        this.grid=grid;
        dp=new Boolean[n][m][1024];
        solve(0,0,grid[0][0]);
        return min;
    }
    public void solve(int r,int c,int curr){
        if(r==n-1&&c==m-1){
            min=Math.min(min,curr);
            return;
        }
        if(dp[r][c][curr]!=null)return;
        dp[r][c][curr]=true;
        if(c+1<m){
            solve(r,c+1,curr^grid[r][c+1]);
        }
        if(r+1<n){
            solve(r+1,c,curr^grid[r+1][c]);
        }
    }
}