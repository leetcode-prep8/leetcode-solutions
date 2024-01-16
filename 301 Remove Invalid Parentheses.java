class Solution {
    Set<String> set = new HashSet<String>(); // no memo?
    // optimize - include char lastSkipped, do not remove if same char. Use List instead of Set

    // l->r, on any extra closed return if no more closedRemovals, also return if remainingRemove > remainingChars
    private void backtrack(String str, StringBuilder s, int extraOpen, int extraClosed, int i, int currOpen) {
        if (currOpen < 0 || extraOpen < 0 || extraClosed < 0)
            return;
        if (i == str.length()) {
            if (currOpen == 0)
                set.add(s.toString());
            return;
        } else if (extraOpen + extraClosed > str.length() - i)
            return;

        char c = str.charAt(i);
        if (c == '(') {
            backtrack(str, s, extraOpen - 1, extraClosed, i + 1, currOpen);
            backtrack(str, s.append(c), extraOpen, extraClosed, i + 1, currOpen + 1);
        } else if (c == ')') {
            backtrack(str, s, extraOpen, extraClosed - 1, i + 1, currOpen);
            backtrack(str, s.append(c), extraOpen, extraClosed, i + 1, currOpen - 1);
        } else {
            backtrack(str, s.append(c), extraOpen, extraClosed, i + 1, currOpen);
        }
        s.delete(s.length() - 1, s.length()); // remove appended
    }

    // Backtrack memo may be [index, remainingRemove]
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<String>();
        int extraOpens = 0, extraClosed = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                extraOpens++;
            } else if (c == ')') {
                if (extraOpens == 0)
                    extraClosed++;
                else
                    extraOpens--;
            }
        }
        backtrack(s, new StringBuilder(), extraOpens, extraClosed, 0, 0);
        return new ArrayList<String>(set);
    }
}