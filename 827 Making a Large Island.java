class Solution {
    int[] parent;
    HashMap<Integer, Integer> islandAreas;

    private int find(int x) {
        while (parent[x] != x) {
            return find(parent[x]);
        }
        return x;
    }

    private void union(int i, int j) {
        parent[find(i)] = find(j);
    }

    private int findIslands(int[][] grid, int i, int j, int p) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;
        if (grid[i][j] != 1)
            return 0;
        grid[i][j] = 2;
        parent[i * grid[0].length + j] = p;
        return findIslands(grid, i - 1, j, p) + findIslands(grid, i + 1, j, p) + findIslands(grid, i, j - 1, p)
                + findIslands(grid, i, j + 1, p) + 1;
    }

    private int flipTile(int[][] grid, int i, int j) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int col = grid[0].length;
        int left = (i - 1) * col + j;
        int right = (i + 1) * col + j;
        int up = i * col + j - 1;
        int down = i * col + j + 1;
        if (i > 0 && grid[i - 1][j] == 2 && !set.contains(find(left))) {
            set.add(find(left));
            sum += islandAreas.get(find(left));
        }
        if (j > 0 && grid[i][j - 1] == 2 && !set.contains(find(up))) {
            set.add(find(up));
            sum += islandAreas.get(find(up));
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 2 && !set.contains(find(right))) {
            set.add(find(right));
            sum += islandAreas.get(find(right));
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 2 && !set.contains(find(down))) {
            set.add(find(down));
            sum += islandAreas.get(find(down));
        }
        return sum + 1;

    }

    public int largestIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        this.parent = new int[rows * cols];
        int maxIsland = 0;
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        islandAreas = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int size = findIslands(grid, i, j, i * cols + j);
                    islandAreas.put(i * cols + j, size);
                    maxIsland = Math.max(maxIsland, size);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {

                    max = Math.max(max, flipTile(grid, i, j));
                }
            }
        }
        return Math.max(max, maxIsland);
    }
    // when iterating, pass in initial i*j, the parent
}