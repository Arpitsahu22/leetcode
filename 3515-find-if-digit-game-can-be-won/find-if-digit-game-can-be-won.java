class Solution {
    public boolean canAliceWin(int[] nums) {
        int single = 0;
        int doubl = 0;

        for (int num : nums) {
            if (num < 10) {
                single += num;
            } else {
                doubl += num;
            }
        }
        return single != doubl;
    }
}