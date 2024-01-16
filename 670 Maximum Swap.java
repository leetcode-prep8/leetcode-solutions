class Solution {
    // each 0~9. negative? int overflow?
    // 4379 -> 9374. furthestIndex[10]. Left to right, if higher to right swap
    private void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int maximumSwap(int num) {
        if (num < 12)
            return num;
        char[] arr = Integer.toString(num).toCharArray();
        int[] furthestIndex = new int[10];
        for (int i = 0; i < arr.length; i++) {
            furthestIndex[(int) (arr[i] - '0')] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            int digit = (int) (arr[i] - '0');
            for (int d = 9; d > digit; d--) {
                if (furthestIndex[d] > i) {
                    swap(arr, i, furthestIndex[d]);
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}