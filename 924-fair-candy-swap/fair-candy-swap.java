class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0;
        int sumB = 0;
        for (int x : aliceSizes) {
            sumA += x;
        }

        for (int y : bobSizes) {
            sumB += y;
        }

        for (int i = 0; i < aliceSizes.length; i++) {

            for (int j = 0; j < bobSizes.length; j++) {

                int newAlice = sumA - aliceSizes[i] + bobSizes[j];

                int newBob = sumB - bobSizes[j] + aliceSizes[i];
                
                if (newAlice == newBob) {
                    return new int[]{aliceSizes[i], bobSizes[j]};
                }
            }
        }

        return new int[]{};
    }
}