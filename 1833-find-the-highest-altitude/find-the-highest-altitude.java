class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int max=0;
        int  altitude [] = new int[n+1];
         for(int i=0; i<n; i++) {
            altitude[i+1] = altitude[i] + gain[i];
            max=Math.max(max,altitude[i+1]);
        }
        

        return max;
        
    }
}