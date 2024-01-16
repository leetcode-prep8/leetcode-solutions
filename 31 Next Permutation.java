class Solution {
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        int j = nums.length - 1;
        if (i != -1) { // right=non-increasing
            while (j > i && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        // right=non-increasing. reverse to be non-decreasing (smallest next perm)
        reverse(nums, i + 1, nums.length - 1);
    }
} // r->l, first digit w greater to right swap w greatest. then sort rest from smallest to largest