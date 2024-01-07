package leetcode_solutions;

class Solution {
    private int findLeftBound(int[] nums, int k) { // for right bound, return start
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] - nums[0] - mid < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public int missingElement(int[] nums, int k) {
        // Approach 2 – BS
        int leftBound = findLeftBound(nums, k);
        int missingCount = nums[leftBound] - nums[0] - leftBound;
        return nums[leftBound] + k - missingCount;

        // Approach 1 – Iterate
        // int missingCount = 0;
        // for (int i = 1; i < nums.length; i++) {
        // missingCount += nums[i] - nums[i - 1] - 1;
        //     if (missingCount >= k) {
        //         return nums[i] - 1 - (missingCount - k);
        //     }
        // }
        // return nums[nums.length - 1] + (k - missingCount);
    }
} // O(logn) time, O(1) space