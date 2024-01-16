class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return true;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j < matrix[0].length - 1) {
                    if (matrix[i][j] != matrix[i + 1][j + 1])
                        return false;
                }
            }
        }
        return true;
    }
} // diags i - j = k, i + j = k. iter every cell check bottom right and bottom left