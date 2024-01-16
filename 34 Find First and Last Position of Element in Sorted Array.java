class Solution {
    private int bs(int[] nums, int n, boolean findLower) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            if (s == e)
                return nums[s] == n ? s : -1;
            else if (e - s == 1) {
                if (findLower) {
                    if (nums[s] == n)
                        return s;
                    return nums[e] == n ? e : -1;
                } else {
                    if (nums[e] == n)
                        return e;
                    return nums[s] == n ? s : -1;
                }
            }
            int mid = s + (e - s) / 2;
            if (findLower) {
                if (n <= nums[mid])
                    e = mid;
                else
                    s = mid + 1;
            } else {
                if (n >= nums[mid])
                    s = mid;
                else
                    e = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int lower = bs(nums, target, true);
        if (lower == -1)
            return new int[] { -1, -1 };
        int upper = bs(nums, target, false);
        return new int[] { lower, upper };
    }
}