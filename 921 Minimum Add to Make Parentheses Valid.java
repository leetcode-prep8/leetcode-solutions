class Solution {
    public int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int insertOpenCount = 0;
        int unclosedOpenCount = 0;
        for (int i = 0; i < s.length(); i++) {
            unclosedOpenCount += s.charAt(i) == '(' ? 1 : -1;
            if (unclosedOpenCount == -1) { // extra ')'
                unclosedOpenCount++;
                insertOpenCount++;
            }
        }
        return unclosedOpenCount + insertOpenCount;
    }
}