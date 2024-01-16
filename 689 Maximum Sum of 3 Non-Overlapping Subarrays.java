class Solution { // Identify DP

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // dp = new int[nums.length][3];
        int[] kSums = new int[nums.length - k + 1]; // sum from i~i+k-1
        // System.out.println("k has Ksums " + kSums.length);
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (i < kSums.length - 1)
                sum -= nums[i + k];
            if (i <= kSums.length - 1)
                kSums[i] = sum;
        }
        int[] leftMaxI = new int[kSums.length];
        int[] rightMaxI = new int[kSums.length];
        int maxI = 0;
        for (int i = 0; i < kSums.length; i++) {
            if (kSums[maxI] < kSums[i])
                maxI = i;
            leftMaxI[i] = maxI;
        }
        maxI = kSums.length - 1;
        for (int i = kSums.length - 1; i >= 0; i--) {
            if (kSums[maxI] <= kSums[i])
                maxI = i;
            rightMaxI[i] = maxI;
        }
        int max = 0;
        int[] res = new int[3];
        for (int j = k; j < kSums.length - k; j++) {
            int i = leftMaxI[j - k], l = rightMaxI[j + k];
            int curr = kSums[i] + kSums[j] + kSums[l];
            if (curr > max) {
                max = curr;
                res[0] = i;
                res[1] = j;
                res[2] = l;
            }
        }
        return res;
    }
}