
class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;

            for (int j = 0; j < i; j++) {
                if (candyType[i] == candyType[j]) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                count++;
            }
        }
        return Math.min(count, n / 2);
    }
}
