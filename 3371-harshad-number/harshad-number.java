class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int original = x;
        int sum = 0;
        while (x > 0) {
            int digit = x % 10;
            sum = sum + digit;
            x = x / 10;
        }
        if (original % sum == 0) return sum;
        return -1;
    }
}