class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int minDistance = Integer.MAX_VALUE;
        int ans = -1;

        int target_x = target[0];
        int target_y = target[1];

        for (int i = 0; i < drones.length; i++) {
            int x = drones[i][0];
            int y = drones[i][1];
            int range = drones[i][2];

            int distance = Math.abs(x - target_x) + Math.abs(y - target_y);

            if (distance <= range && distance < minDistance) {
                minDistance = distance;
                ans = i;
            }
        }

        return ans;
    }
}