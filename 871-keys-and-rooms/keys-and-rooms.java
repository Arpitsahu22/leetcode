class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int c = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int key : rooms.get(curr)) {
                if (vis[key] == false) {
                    vis[key] = true;
                    c++;
                    q.add(key);
                }
            }
        }
        return c == rooms.size();
    }
}