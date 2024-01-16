class Solution {
    int sum = 0;

    private void traverse(TreeNode n, int curr) {
        if (n.left == null && n.right == null) {
            sum += 10 * curr + n.val;
        } else if (n.left != null && n.right != null) {
            traverse(n.left, 10 * curr + n.val);
            traverse(n.right, 10 * curr + n.val);
        } else if (n.left != null)
            traverse(n.left, 10 * curr + n.val);
        else
            traverse(n.right, 10 * curr + n.val);
    }
    // public int sumNumbers(TreeNode root) {
    //     traverse(root, 0);
    //     return sum;
    // }

    public int sumNumbers(TreeNode n) {
        TreeNode root = n;
        int sum = 0;
        int curr = 0, steps = 0;
        while (root != null) {
            if (root.left == null)
                root = root.right;
            else {
                TreeNode predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    steps++;
                }
                if (predecessor.right == null) { // yet to traverse, set predecessor pointer
                    curr = curr * 10 + root.val;
                    predecessor.right = root;
                    root = root.left;
                } else { // predecessor.right == root, so alr traversed 
                    predecessor.right = null;
                    root = root.right;
                    if (predecessor.left == null) { // just for this problem
                        sum += curr;
                    }
                    for (int i = 0; i < steps; i++)
                        curr /= 10;
                }
            }
        }
        return sum;
    }
}
// Simple – DFS, Fastest - Iterative, Constant Space – Morris