class Solution {
    // private int traverse(TreeNode n, int low, int high) {
    //     if (n == null) return 0;
    //     int sum = 0;
    //     if (low <= n.val && n.val <= high) sum += n.val;
    //     if (n.val > low) sum += traverse(n.left, low, high);
    //     if (n.val < high) sum += traverse(n.right, low, high);
    //     return sum;
    // }
    public int rangeSumBST(TreeNode root, int low, int high) {
        // return traverse(root, low, high);

        // in-order traversal 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        int sum = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val >= low && curr.val <= high)
                sum += curr.val;
            curr = curr.right;
        }
        return sum;
    }
}

// private void postOrder(TreeNode root) {
//     Stack<TreeNode> s1 = new Stack<>();
//     Stack<TreeNode> s2 = new Stack<>();
//     s1.push(root);
//     while (!s1.isEmpty()) {
//         TreeNode curr = s1.pop();
//         s2.push(curr);
//         if (curr.left != null) s1.push(curr.left);
//         if (curr.right != null) s1.push(curr.right);
//     }
//     while (!s2.isEmpty()) {
//         TreeNode curr = s2.pop(); // eval
//     }
// }

// private void preOrder(TreeNode root) {
//     Stack<TreeNode> stack = new Stack<TreeNode>();
//     stack.push(root);
//     while (!stack.isEmpty()) {
//         TreeNode curr = stack.pop();
//         if (curr.right != null) stack.push(curr.right);
//         if (curr.left != null) stack.push(curr.left);
//     }
// }

// private void inOrder(TreeNode root) {
//     Stack<TreeNode> stack = new Stack<TreeNode>();
//     TreeNode curr = root;
//     while (curr != null || !stack.isEmpty()) {
//         while (curr != null) {
//             stack.push(curr);
//             curr = curr.left;
//         }
//         curr = stack.pop();
//         curr = curr.right;
//     }
// }
