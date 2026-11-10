class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int start = 0;
        int end = 0;
        int ans = 0;
        int fruit1 = -1;
        int fruit2 = -1;
        while (end < n) {
            if (fruit1 == -1 || fruits[end] == fruit1) {
                fruit1 = fruits[end];
            }
            else if (fruit2 == -1 || fruits[end] == fruit2) {
                fruit2 = fruits[end];
            }
            else {
                start = end - 1;
                while (start >= 0 && fruits[start] == fruits[end - 1]) {
                    start--;
                }
                start++;
                fruit1 = fruits[end - 1];
                fruit2 = fruits[end];
            }
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}
