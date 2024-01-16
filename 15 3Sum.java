class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int compl = -1 * nums[i];
            if (compl < 0)
                break;
            int s = i + 1, e = nums.length - 1;
            while (s < e) {
                int sum = nums[s] + nums[e];
                if (sum == compl) {
                    List<Integer> list = Arrays.asList(nums[i], nums[s], nums[e]);
                    ans.add(list);
                    int prevE = nums[e];
                    e--;
                    while (e > s && nums[e] == prevE)
                        e--;
                } else if (sum > compl) {
                    e--;
                } else {
                    s++;
                }
            }
        }
        return ans;
    }
}