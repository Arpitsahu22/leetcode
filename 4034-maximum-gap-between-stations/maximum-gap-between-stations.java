class Solution {
    public int maximumGap(String skill, String station) {
        
        int n = skill.length();
        int m = station.length();
        int[] earl = new int[n];

        int j = 0;

        for (int i = 0; i < n; i++) {
            while (station.charAt(j) != skill.charAt(i)) {
                j++;
            }

            earl[i] = j;
            j++;
        }
         int[] latest = new int[n];

        j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            while (station.charAt(j) != skill.charAt(i)) {
                j--;
            }

            latest[i] = j;
            j--;
        }
         int ans = 0;

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, latest[i] - earl[i - 1]);
        }

        return ans;
    }
}