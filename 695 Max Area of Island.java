class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, islandArea(i, j, grid));
                }
            }
        }
        return max;
    }

    private int islandArea(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        return 1 + islandArea(i - 1, j, grid) + islandArea(i + 1, j, grid) + islandArea(i, j - 1, grid)
                + islandArea(i, j + 1, grid);
    }
}