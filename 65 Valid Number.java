class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;
        boolean foundExp = false, foundDot = false, foundDigit = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                foundDigit = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } else if (c == 'e' || c == 'E') {
                if (!foundDigit || foundExp)
                    return false;
                foundExp = true;
                foundDigit = false;
            } else if (c == '.') {
                if (foundDot || foundExp)
                    return false;
                foundDot = true;
            } else {
                return false;
            }
        }
        return foundDigit;
    }
}