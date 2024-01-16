class Solution { // for each house, bfs: add distance, fill grid with emptyLandVal, track min for cell

    public int shortestDistance(int[][] grid) {
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] totalDist = new int[rows][cols];

        int emptyLandValue = 0;
        int min = Integer.MAX_VALUE; // calc min throughout
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 1)
                    continue;

                // on building, reset steps, q, and min
                int steps = 0;
                Queue<int[]> q = new LinkedList<int[]>();
                q.offer(new int[] { row, col });
                min = Integer.MAX_VALUE;

                while (!q.isEmpty()) { // on next step, incr steps and exhaust current q
                    int size = q.size();
                    steps++;
                    for (int i = 0; i < size; i++) {
                        int[] cell = q.poll();
                        for (int[] dir : dirs) {
                            int newR = cell[0] + dir[0];
                            int newC = cell[1] + dir[1];
                            if (newR >= 0 && newR < rows && newC >= 0 && newC < cols
                                    && grid[newR][newC] == emptyLandValue) {
                                grid[newR][newC]--; // ensures that the totalDist we consider is only for cells that can access every building
                                totalDist[newR][newC] += steps;
                                q.offer(new int[] { newR, newC });

                                min = Math.min(min, totalDist[newR][newC]);
                            }
                        }
                    }
                }
                // on building, decr emptyLandValue
                emptyLandValue--;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}