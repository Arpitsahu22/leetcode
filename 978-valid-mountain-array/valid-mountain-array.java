class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        if (n < 3) {
            return false;
        }

        for (int peak = 1; peak < n - 1; peak++) {

            boolean increasing = true;
            for (int i = 0; i < peak; i++) {
                if (arr[i] >= arr[i + 1]) {
                    increasing = false;
                    break;
                }
            }

            boolean decreasing = true;
            for (int i = peak; i < n - 1; i++) {
                if (arr[i] <= arr[i + 1]) {
                    decreasing = false;
                    break;
                }
            }

            if (increasing && decreasing) {
                return true;
            }
        }

        return false;
    }
}