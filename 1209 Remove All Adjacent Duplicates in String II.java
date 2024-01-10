class Solution {
    class Pair {
        Character c;
        int count;
        public Pair(Character c, int count){
            this.c = c;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<Pair>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().c != c) {
                stack.push(new Pair(c, 1));
            } else {
                if (++stack.peek().count == k) {
                    stack.pop();
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (Pair currChar : stack) {
            for (int i = 0; i < currChar.count; i++) result.append(currChar.c);
        }
        return result.toString();
    }
} // O(n) time, O(n) space
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/submissions/