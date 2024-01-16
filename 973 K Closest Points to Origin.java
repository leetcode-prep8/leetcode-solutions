class Solution {
    // Smallest K 1. minPQ O(nlogk) O(k). 2. QuickSort O(nlogn) O(n)
    // dist double overflow?
    private double dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int a, int b) {
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }

    private int partition(int[][] points, int low, int high) {
        int mid = low + (high - low) / 2;
        double val = dist(points[mid]);
        int wall = low;
        swap(points, mid, high);
        for (int i = low; i < high; i++) {
            if (dist(points[i]) < val) {
                swap(points, wall, i);
                wall++;
            }
        }
        swap(points, wall, high);
        return wall;
    }

    private void quickSort(int[][] points, int low, int high) {
        if (low < high) {
            int p = partition(points, low, high);
            quickSort(points, low, p - 1);
            quickSort(points, p + 1, high);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        if (k <= 0 || points == null || points.length == 0 || points[0].length == 0)
            return new int[0][0];
        quickSort(points, 0, points.length - 1);
        int[][] res = new int[k][2];
        for (int[] p : points)
            System.out.println(p[0] + " " + p[1]);

        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }
}