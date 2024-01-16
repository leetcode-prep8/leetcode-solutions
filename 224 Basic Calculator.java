class Solution { // -2 - (2-(1+4)) + 1
    public int calculate(String s) { // only complexity is +-()
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0, currNum = 0;
        int op = 1;
        for (int i = 0; i < s.length(); i++) { // use stack only for entering ()
            char c = s.charAt(i);
            if (Character.isWhitespace(c))
                continue;
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (int) (c - '0');
                continue;
            }
            if (c == '+' || c == '-') {
                res += currNum * op;
                op = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(op);
                res = 0;
                op = 1;
            } else if (c == ')') {
                res += currNum * op;
                res *= stack.pop(); // sign
                res += stack.pop();
                op = 1;
            }
            currNum = 0;
        }
        return res + currNum * op;
    }
}