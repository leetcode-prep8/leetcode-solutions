class Solution {
    TreeNode subtreeRoot;
    int maxDepth;

    private int findDeepestSubtree(TreeNode node, int depth) {
        if (node == null)
            return depth;
        int left = findDeepestSubtree(node.left, depth + 1);
        int right = findDeepestSubtree(node.right, depth + 1);
        if (left == right) {
            maxDepth = Math.max(maxDepth, left);
            if (left == maxDepth)
                subtreeRoot = node;
        }
        return Math.max(left, right);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return root;
        subtreeRoot = null;
        maxDepth = 0;
        findDeepestSubtree(root, 0);
        return subtreeRoot;
    }
} // O(n) time O(n) space
  // https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/