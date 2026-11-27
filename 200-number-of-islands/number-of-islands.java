class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int row = curr[0];
                        int col = curr[1];
                        for (int k = 0; k < 4; k++) {
                            int nr = row + dir[k][0];
                            int nc = col + dir[k][1];
                            if (nr >= 0 && nc >= 0 &&
                                nr < m && nc < n &&
                                grid[nr][nc] == '1') {

                                grid[nr][nc] = '0';
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}