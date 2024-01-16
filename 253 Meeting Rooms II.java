class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // int n = intervals.length;
        // int[] starts = new int[n], ends = new int[n];
        // for (int i = 0; i < n; i++) {
        //     starts[i] = intervals[i][0];
        //     ends[i] = intervals[i][1];
        // }
        // Arrays.sort(starts);
        // Arrays.sort(ends);
        // int e = 0;
        // int count = 0;
        // for (int start : starts) {
        //     if (e < n && ends[e] <= start) { // if not while to only decr by 1 at most. So we main
        //         e++;
        //         count--;
        //     }
        //     count++;
        // }
        // return count;

        Arrays.sort(intervals, ((a, b) -> (a[0] - b[0])));
        int curr = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] i : intervals) {
            if (!pq.isEmpty() && pq.peek() <= i[0]) { // or use while and track max
                curr--;
                pq.poll();
            }
            curr++;
            pq.offer(i[1]);
        }
        return curr;
    }
}