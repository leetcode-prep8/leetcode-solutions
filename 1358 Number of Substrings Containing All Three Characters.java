class Solution {
    private boolean foundThree(int[] lastI) {
        for (int n : lastI) {
            if (n == 0)
                return false;
        }
        return true;
    }

    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int sum = 0;
        int i = 0, j = 0;

        while (i < s.length() && j < s.length()) {
            freq[s.charAt(j) - 'a']++;
            j++;
            while (foundThree(freq) && i <= j) {
                sum += s.length() - j + 1;
                freq[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return sum;
    }
}