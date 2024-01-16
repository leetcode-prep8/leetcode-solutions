class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xCords = new ArrayList<>();
        List<Integer> yCords = new ArrayList<>();
        int i = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    xCords.add(row);
                    i++;
                }
            }
        }
        i = 0;
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    yCords.add(col);
                    i++;
                }
            }
        }
        int x = xCords.get(xCords.size() / 2);
        int y = yCords.get(yCords.size() / 2);
        int sum = 0;
        for (int j = 0; j < xCords.size(); j++) {
            sum += Math.abs(x - xCords.get(j)) + Math.abs(y - yCords.get(j));
        }
        return sum;
    }
}