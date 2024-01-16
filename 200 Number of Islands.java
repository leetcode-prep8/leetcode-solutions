class Solution {
    private void findIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = '2';
        findIsland(grid, i - 1, j);
        findIsland(grid, i + 1, j);
        findIsland(grid, i, j - 1);
        findIsland(grid, i, j + 1);

    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    findIsland(grid, i, j);
                }
            }
        }
        return count;
    }
}