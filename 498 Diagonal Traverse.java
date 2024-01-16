class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[] res = new int[rows * cols];
        int row = 0, col = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[row][col];
            if ((row + col) % 2 == 0) { // go up
                if (col == cols - 1)
                    row++;
                else if (row == 0)
                    col++;
                else {
                    row--;
                    col++;
                }
            } else {
                if (row == rows - 1)
                    col++;
                else if (col == 0)
                    row++;
                else {
                    col--;
                    row++;
                }
            }
        }
        return res;
    }
}