class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.add(source);
        vis[source] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == destination) {
                return true;
            }

            for (int neigh : graph.get(curr)) {
                if (vis[neigh] == false) {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        return false;
    }
}