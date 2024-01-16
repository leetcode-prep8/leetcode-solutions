class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2 || k == 0)
            return false;
        HashMap<Integer, Integer> modSums = new HashMap<>();
        int modSum = 0;
        for (int i = 0; i < nums.length; i++) {
            modSum = (modSum + (nums[i] % k + k) % k) % k;
            if (i > 0 && modSum == 0)
                return true; //curr subarr
            if (i - modSums.getOrDefault(modSum, i) > 1)
                return true; // diff btwn two subarrays, if diff is 1 then there's only one val btwn the two arrs
            modSums.putIfAbsent(modSum, i);
        }
        return false;
    }
}