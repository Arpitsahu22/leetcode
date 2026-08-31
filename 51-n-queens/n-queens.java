class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> curr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder currRow = new StringBuilder();
            for (int j = 0; j < n; j++) {
                currRow.append(".");
            }
            curr.add(currRow);
        }
        solve(ans, curr, n, 0);
        return ans;
    }
    public boolean check(int r, int c, List<StringBuilder> board) {
        int n = board.size();
        for (int i = 0; i < r; i++) {
            if (board.get(i).charAt(c) == 'Q') {
                return false;
            }
        }
        int i = r - 1;
        int j = c - 1;
        while (i >= 0 && j >= 0) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = r - 1;
        j = c + 1;

        while (i >= 0 && j < n) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    public void solve(List<List<String>> ans, List<StringBuilder> board, int n, int currRow) {
        if (currRow >= n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.size(); i++) {
                String currR = board.get(i).toString();
                temp.add(currR);
            }
            ans.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (check(currRow, col, board) == true) {
                board.get(currRow).setCharAt(col, 'Q');
                solve(ans, board, n, currRow + 1);
                board.get(currRow).setCharAt(col, '.');
            }
        }
    }
}