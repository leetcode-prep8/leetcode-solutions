class Solution {
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int wall = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                swap(nums, wall++, i);
        }
    }
}