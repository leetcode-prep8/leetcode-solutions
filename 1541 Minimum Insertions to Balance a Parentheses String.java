class Solution {
    public int minInsertions(String s) {
        if (s.length() == 0)
            return 0;
        int leftC = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftC++;
                continue;
            }
            if (i == s.length() - 1 || s.charAt(i + 1) != ')') {
                if (leftC == 0)
                    count += 2;
                else {
                    count++;
                    leftC--;
                }
            } else {
                if (leftC == 0)
                    count++;
                else
                    leftC--;
                i++;
            }
        }
        return count + 2 * leftC;
    }
}