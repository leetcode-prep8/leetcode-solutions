class TicTacToe {
    int[] rows;
    int[] cols;
    int[] diags;
    int n;

    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diags = new int[2];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rows[row] += add;
        cols[col] += add;
        if (row + col == n - 1)
            diags[1] += add;
        if (row - col == 0)
            diags[0] += add;
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diags[0]) == n ||
                Math.abs(diags[1]) == n)
            return player;
        return 0;
    }
}