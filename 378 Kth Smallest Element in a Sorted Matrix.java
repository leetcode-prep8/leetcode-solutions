class Solution {
    int[][] matrix;
    int k;
    int length;

    private int getLessThanOrEqualCount(int limit, int[] bounds) {
        int count = 0;
        int row = length - 1, col = 0;
        while (row >= 0 && col < length) {
            int val = matrix[row][col];
            if (val <= limit) {
                bounds[0] = Math.max(bounds[0], val);
                count += row + 1;
                col++;
            } else {
                bounds[1] = Math.min(bounds[1], val);
                row--;
            }
        }
        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        this.k = k;
        this.length = matrix.length;
        int low = matrix[0][0], hi = matrix[length - 1][length - 1];
        while (low < hi) {
            int[] bounds = { Integer.MIN_VALUE, Integer.MAX_VALUE };
            int midVal = low + (hi - low) / 2;
            int count = getLessThanOrEqualCount(midVal, bounds);
            if (count == k)
                return bounds[0];
            else if (count < k) {
                low = bounds[1];
            } else {
                hi = bounds[0];
            }
        }
        return low;
    }

    // Approach 1 – PQ
    class Cell {
        int row;
        int col;
        int val;

        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((a, b) -> a.val - b.val);
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Cell(i, 0, matrix[i][0]));
        }
        for (int i = 0; i < k; i++) {
            Cell currCell = pq.poll();
            if (i == k - 1)
                return currCell.val;
            int nextCol = currCell.col + 1;
            if (nextCol < matrix[0].length) {
                currCell = new Cell(currCell.row, nextCol, matrix[currCell.row][nextCol]);
                pq.offer(currCell);
            }
        }
        return -1;
    }
} // O(nlogn) time, O(n) or O(1) space