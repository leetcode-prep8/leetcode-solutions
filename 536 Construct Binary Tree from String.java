class Solution {
    int index;

    private int getValue(String s) {
        boolean isNegative = false;
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        }
        int num = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + (int) (s.charAt(index) - '0');
            index++;
        }
        return isNegative ? -num : num;
    }

    // Approach 1 – Recursion
    private TreeNode constructTree(String s) {
        int value = getValue(s);
        TreeNode currNode = new TreeNode(value);
        if (index == s.length())
            return currNode;

        if (s.charAt(index) == '(') {
            index++;
            currNode.left = constructTree(s);
            index++;
        }
        if (index == s.length())
            return currNode;
        if (s.charAt(index) == '(') {
            index++;
            currNode.right = constructTree(s);
            index++;
        }
        return currNode;
    }

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0)
            return null;
        index = 0;
        return constructTree(s);
    }

    // Approach 2 – Stack
    // public TreeNode str2tree(String s) {
    //     if (s == null || s.length() == 0) return null;
    //     index = 0;
    //     TreeNode root = new TreeNode(getValue(s));
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     int currNum = 0;
    //     boolean isNegative = false;
    //     for (int i = index; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (Character.isDigit(c)) {
    //             currNum = currNum * 10 + (int)(c - '0');
    //             if (i + 1 < s.length() && !Character.isDigit(s.charAt(i + 1))) {
    //                 currNum = isNegative ? -currNum : currNum;
    //                 isNegative = false;
    //                 TreeNode parent = stack.peek();
    //                 TreeNode child = new TreeNode(currNum);
    //                 if (parent.left == null)  parent.left = child;
    //                 else parent.right = child;
    //                 currNum = 0;
    //                 stack.push(child);
    //             }
    //         } else if (c == '-') {
    //             isNegative = true;
    //         } else if (c == ')') {
    //             stack.pop();
    //         }
    //     }
    //     return root;
    // }
} // O(n) time | O(H) space
  // https://leetcode.com/problems/construct-binary-tree-from-string/