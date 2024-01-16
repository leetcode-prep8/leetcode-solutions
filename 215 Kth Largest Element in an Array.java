class Solution {

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int partition(int[] arr, int k, int h) {
        int mid = l + (h - l) / 2;
        int val = arr[mid];
        swap(arr, mid, h);
        int wall = l;
        for (int i = l; i < h; i++) {
            if (arr[i] < val) swap(arr, i, wall++);
        }
        swap(arr, wall, h);
        return wall;
    }
    private void quickSelect(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int p = partition(arr, s, e);
            if (p == target) return;
            else if (p < target) s = p + 1;
            else e = p - 1;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        // Approach 2 – QuickSelect for kth in non-inc arr
        quickSelect(nums, nums.length - k);
        return nums[nums.length - k];

        // Approach 1 - Min PQ of max elements O(nlogk) O(k)
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int n : nums) {
        //     if (pq.size() < k) pq.offer(n);
        //     else if (pq.peek() < n) {
        //         pq.poll();
        //         pq.offer(n);
        //     }
        // }
        // return pq.poll();
    }
}