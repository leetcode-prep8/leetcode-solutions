class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else
                right = mid;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++)
            result.add(arr[i]);
        return result;
    }
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     // already sorted - BS first index >= x. two pointers expand window
    //     int low = 0, high = arr.length;
    //     while (low < high) {
    //         int mid = low + (high - low) / 2;
    //         if (arr[mid] >= x) high = mid;
    //         else low = mid + 1;
    //     } // low is leftmost greater or equal to x

    //     // expand sliding window, exclusive start inclusive end
    //     List<Integer> res = new ArrayList<>();
    //     int p1 = low - 1, p2 = low;
    //     while (p2 - p1 - 1 < k) {
    //         if (p1 == -1) p2++;
    //         else if (p2 == arr.length || Math.abs(arr[p1] - x) <= Math.abs(arr[p2] - x)) p1--;
    //         else p2++;
    //     }
    //     for (int i = p1 + 1; i < p2; i++) res.add(arr[i]);
    //     return res;
    // }
}