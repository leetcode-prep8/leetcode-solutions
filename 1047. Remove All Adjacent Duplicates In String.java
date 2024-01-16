class Solution {
    public String removeDuplicates(String s) {
        int i = 0, length = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (length != 0 && sb.charAt(length - 1) == s.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                length--;
            } else {
                sb.append(s.charAt(i));
                length++;
            }
            i++;
        }
        return sb.toString();
    }
}