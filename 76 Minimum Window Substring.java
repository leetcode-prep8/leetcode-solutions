class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";
        int[] freq = new int[128];
        for (char c : t.toCharArray())
            freq[c]++;
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int ansS = 0;
        int count = t.length();
        while (end < s.length()) {
            int c = (int) s.charAt(end);
            if (freq[c] > 0)
                count--;
            freq[c]--;
            end++;
            while (count == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    ansS = start;
                }
                int startC = (int) s.charAt(start);
                if (freq[startC] == 0) {
                    count++;
                }
                freq[startC]++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansS, ansS + minLen);
    }
}