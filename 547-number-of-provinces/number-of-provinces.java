class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                count++;
                q.offer(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[curr][j] == 1 &&
                            vis[j] == false) {
                            vis[j] = true;
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}