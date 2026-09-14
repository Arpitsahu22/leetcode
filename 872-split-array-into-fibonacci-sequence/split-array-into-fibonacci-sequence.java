class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new ArrayList<>();
        solve(num, 0, ans);
        return ans;
    }
    public boolean solve(String num, int i, List<Integer> ans) {
        if (i == num.length()) {
            if (ans.size() >= 3) return true;
            return false;
        }
        long current = 0;
        for (int j = i; j < num.length(); j++) {
            if (j > i && num.charAt(i) == '0') break;
            current = current * 10 + (num.charAt(j) - '0');
            if (current > Integer.MAX_VALUE) break;
            if (ans.size() >= 2) {
                long sum = (long) ans.get(ans.size() - 1) + ans.get(ans.size() - 2);
                if (current < sum) continue;
                if (current > sum) break;
            }
            ans.add((int) current);
            if (solve(num, j + 1, ans)) return true;
            ans.remove(ans.size() - 1);
        }
        return false;
    }
}
