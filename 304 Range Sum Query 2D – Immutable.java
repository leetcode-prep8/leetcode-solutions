class NumMatrix {
    int[][] areas;
    int col;

    public NumMatrix(int[][] matrix) {
        this.col = matrix[0].length;
        this.areas = new int[matrix.length][matrix[0].length];
        int[] colSum = new int[col];
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < col; j++) {
                if (i != 0)
                    sum += colSum[j];
                sum += matrix[i][j];
                areas[i][j] = sum;
                colSum[j] += matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = areas[row2][col2];
        if (row1 > 0)
            sum -= areas[row1 - 1][col2];
        if (col1 > 0)
            sum -= areas[row2][col1 - 1];
        if (row1 > 0 && col1 > 0)
            sum += areas[row1 - 1][col1 - 1];
        return sum;
    }
}