class Solution {
    Integer[][] dp;

    private int getMinRemovals(String s, int i, int j) {
        if (dp[i][j] != null)
            return dp[i][j];
        if (i == j)
            return 0;
        else if (j - i == 1) {
            if (s.charAt(i) == s.charAt(j))
                return 0;
            else
                return 1;
        }
        int removals = 0;
        if (s.charAt(i) == s.charAt(j)) {
            removals = getMinRemovals(s, i + 1, j - 1);
        } else {
            removals = 1 + Math.min(getMinRemovals(s, i + 1, j), getMinRemovals(s, i, j - 1));
        }
        dp[i][j] = removals;
        return removals;
    }

    public boolean isValidPalindrome(String s, int k) {
        if (s == null || s.length() == 0)
            return false;
        dp = new Integer[s.length() + 1][s.length() + 1];
        int minRemovals = getMinRemovals(s, 0, s.length() - 1);
        return minRemovals <= k;
    }
}