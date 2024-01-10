class Solution {
    public String addSpaces(String s, int[] spaces) {
        if (spaces.length == 0) return s;
        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (pointer < spaces.length && i == spaces[pointer]) {
                sb.append(" ");
                pointer++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
} // O(n) time, O(1) space
// https://leetcode.com/problems/adding-spaces-to-a-string/description/