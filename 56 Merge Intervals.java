class Solution {
    public int[][] merge(int[][] intervals) { // O(nlogn) O(n)
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1])
                res.getLast()[1] = Math.max(intervals[i][1], res.getLast()[1]);
            else
                res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}