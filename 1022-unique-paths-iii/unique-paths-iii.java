class Solution {
    public int uniquePathsIII(int[][] grid) {
        int sr = 0;
        int sc = 0;
        int totalcells = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) continue;
                    totalcells++;
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return solve(grid, sr, sc, visited, totalcells);
    }
    public int solve(int[][] grid, int r, int c, boolean[][] visited, int cells) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return 0;
        if (grid[r][c] == -1 || visited[r][c] == true) return 0;
        if (grid[r][c] == 2) {
            if (cells == 1) {
                return 1;
            }
            return 0;
        }
        visited[r][c] = true;
        int down = solve(grid, r + 1, c, visited, cells - 1);
        int left = solve(grid, r, c - 1, visited, cells - 1);
        int right = solve(grid, r, c + 1, visited, cells - 1);
        int up = solve(grid, r - 1, c, visited, cells - 1);
        visited[r][c] = false;
        return down + left + right + up;
    }
}