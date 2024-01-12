class Solution {
    char[] s1, s2;
    Boolean[][][] dp;

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean checkEquality(int i, int j, int diff) {
        if (i == s1.length && j == s2.length)
            return diff == 0;
        if (dp[i][j][diff + 1000] != null)
            return dp[i][j][diff + 1000];

        if (i < s1.length && j < s2.length && !isDigit(s1[i]) && !isDigit(s2[j]) && diff == 0) { // letter:letter
            if (s1[i] != s2[j])
                return dp[i][j][diff] = false;
            return dp[i][j][diff] = checkEquality(i + 1, j + 1, diff);
        }
        if (j < s2.length && diff < 0 && !isDigit(s2[j])) { // num:letter
            return dp[i][j][diff + 1000] = checkEquality(i, j + 1, diff + 1);
        }
        if (i < s1.length && diff > 0 && !isDigit(s1[i])) { // letter:num
            return dp[i][j][diff + 1000] = checkEquality(i + 1, j, diff - 1);
        }
        // num:num
        int num = 0;
        int numIndex = i;
        while (numIndex < s1.length && isDigit(s1[numIndex])) {
            num = num * 10 + (s1[numIndex] - '0');
            if (checkEquality(numIndex + 1, j, diff - num))
                return dp[i][j][diff - num + 1000] = true;
            numIndex++;
        }
        num = 0;
        numIndex = j;
        while (numIndex < s2.length && isDigit(s2[numIndex])) {
            num = num * 10 + (s2[numIndex] - '0');
            if (checkEquality(i, numIndex + 1, diff + num))
                return dp[i][j][diff + num + 1000] = true;
            numIndex++;
        }
        return dp[i][j][diff + 1000] = false;
    }

    public boolean possiblyEquals(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        dp = new Boolean[s1.length() + 1][s2.length() + 1][2000]; // diff is -1000~1000
        return checkEquality(0, 0, 0);
    }
} // O(N^2) time, O(N^2) space, where N is length of longer string