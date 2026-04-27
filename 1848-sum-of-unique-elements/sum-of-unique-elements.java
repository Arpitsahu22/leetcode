class Solution {
  public int sumOfUnique(int[] nums) {
    int ans = 0;
    int max = 0;
    for (int num : nums) {
      if (num > max) {
        max = num;
      }
    }
    int[] count = new int[max + 1];
    for (int num : nums) {
      count[num]++;
    }
    for (int i = 0; i <= max; i++) {
      if (count[i] == 1) {
        ans += i;
      }
    }
    return ans;
  }
}