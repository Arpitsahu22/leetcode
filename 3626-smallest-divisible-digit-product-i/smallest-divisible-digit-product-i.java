class Solution {
    public int smallestNumber(int n, int t) {

        for (int i = n; ; i++) {

            int product = 1;
            int x = i;

            while (x > 0) {
                int digit = x % 10;
                product = product * digit;
                x = x / 10;
            }

            if (product % t == 0) {
                return i;
            }
        }
    }
}