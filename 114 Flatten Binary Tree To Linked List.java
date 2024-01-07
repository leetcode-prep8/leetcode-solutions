class Solution {
    public void flatten(TreeNode root) {
        // Approach 1 – Iterative O(n) time O(n) space
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null)
                prev.right = curr;
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
            curr.left = null;
            prev = curr;
        }

        // Approach 2 – Morris O(n) time O(1) space
        // TreeNode prev = null;
        // TreeNode curr = root;
        // while (curr != null) {
        //     if (curr.left != null) {
        //         TreeNode predecessor = curr.left;
        //         while (predecessor != null && predecessor.right != null) predecessor = predecessor.right;
        //         predecessor.right = curr.right;
        //     }
        //     if (prev != null) prev.right = curr;
        //     prev = curr;
        //     if (curr.left != null) curr = curr.left;
        //     else curr = curr.right;
        //     prev.left = null;
        // }
    }
}