class Solution {
    private int binarySearchOrAdd(List<Integer> list, int n, boolean add) {
        int s = 0, e = list.size() - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (n > list.get(m)) {
                s = m + 1;
            } else if (n < list.get(m))
                e = m - 1;
            else {
                s = m;
                break;
            }
        }
        if (add)
            list.add(s, n);
        return s;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Integer> window = new ArrayList<>();
        for (int i = 0; nums.length < k ? i < nums.length : i < k; i++) {
            binarySearchOrAdd(window, nums[i], true);
        }
        double[] ans = new double[nums.length - k + 1];
        for (int i = k; i <= nums.length; i++) {
            if (k % 2 == 1)
                ans[i - k] = window.get(k / 2);
            else
                ans[i - k] = window.get(k / 2 - 1) / 2.0 + window.get(k / 2) / 2.0;
            window.remove(binarySearchOrAdd(window, nums[i - k], false));
            if (i < nums.length)
                binarySearchOrAdd(window, nums[i], true);
        }
        return ans;
    }
}