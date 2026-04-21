class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int size = flowerbed.length;

        for (int i = 0; i < size; i++) {
            if (flowerbed[i] == 0) {
                boolean left = (i == 0) || (flowerbed[i - 1] == 0);
                boolean right = (i == size - 1) || (flowerbed[i + 1] == 0);

                if (left && right) {
                    flowerbed[i] = 1; 
                    count++;

                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }
}