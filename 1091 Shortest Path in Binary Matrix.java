class Solution {
    int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    private void addValidPositions(int[][] grid, Queue<int[]> q, boolean[][] visited, int r, int c) {
        for (int[] dir : dirs) {
            int row = r + dir[0], col = c + dir[1];
            if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length || visited[row][col]
                    || grid[row][col] == 1)
                continue;
            q.offer(new int[] { row, col });
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        if (grid[0][0] == 1)
            return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                int row = pos[0], col = pos[1];
                if (row == grid.length - 1 && col == grid[0].length - 1)
                    return steps;
                if (visited[row][col])
                    continue;
                visited[row][col] = true;
                addValidPositions(grid, q, visited, row, col);
            }
            steps++;
        }
        return -1;
    }
}