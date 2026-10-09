class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        while (n > 1) {
            Arrays.sort(stones, 0, n);

            int a = stones[n - 1];
            int b = stones[n - 2];
            
            stones[n - 2] = a - b;
            n--;
        }
        return stones[0];
    }
}