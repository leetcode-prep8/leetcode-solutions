class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0;
        int maxCount = 0, zeroCount = 0;
        while (end < nums.length) {
            if (nums[end] == 0)
                zeroCount++;

            while (zeroCount > k) {
                if (nums[start] == 0)
                    zeroCount--;
                start++;
            }

            maxCount = Math.max(maxCount, end - start + 1);
            end++;
        }
        return maxCount;
    }
}
