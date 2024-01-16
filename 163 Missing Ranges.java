class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            ans.add(Arrays.asList(lower, upper));
            return ans;
        }
        if (nums[0] > lower) {
            ans.add(Arrays.asList(lower, nums[0] - 1));
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                ans.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
            }
        }
        if (nums[nums.length - 1] < upper) {
            ans.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
        }
        return ans;

    }
}
