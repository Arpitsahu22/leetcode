class Solution {
    public int pivotInteger(int n) {
        int suffix= n*(n+1)/2 , prefix=0;
        for(int i=1; i<=n; i++){
            prefix += i;
            if(suffix==prefix) return i;
            suffix-=i;
        }
        return -1;
    }
}
