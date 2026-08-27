class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    ans = Math.max(ans, solve(grid, i, j, visited));
                }
            }
        }
        return ans;
    }
    public int solve(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return 0;
        if (grid[r][c] == 0 || visited[r][c] == true) return 0;
        
        visited[r][c] = true;
        int down = solve(grid, r + 1, c, visited);
        int left = solve(grid, r, c - 1, visited);
        int right = solve(grid, r, c + 1, visited);
        int up = solve(grid, r - 1, c, visited);
        visited[r][c] = false;
        return grid[r][c] + Math.max(Math.max(down, up),Math.max(left, right));
    }
}