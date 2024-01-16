class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lower = 1, higher = 0;
        for (int w : weights) {
            lower = Math.max(lower, w);
            higher += w;
        }
        int min = Integer.MAX_VALUE;
        while (lower <= higher) {
            int mid = lower + (higher - lower) / 2;
            int dayNum = 0;
            int curr = 0;
            for (int w : weights) {
                if (curr + w > mid) {
                    dayNum++;
                    curr = w;
                } else {
                    curr += w;
                }
            }
            dayNum++;
            if (dayNum <= days) {
                min = Math.min(min, mid);
                higher = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return min;
    }
}