class Solution {
    TreeNode ancestor;
    int maxDepth;

    private int findAncestorOfDeepest(TreeNode node, int depth) {
        if (node == null)
            return depth - 1;
        maxDepth = Math.max(maxDepth, depth);
        int left = findAncestorOfDeepest(node.left, depth + 1);
        int right = findAncestorOfDeepest(node.right, depth + 1);
        if (left == right && left == maxDepth)
            ancestor = node;
        return Math.max(left, right);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null)
            return null;
        ancestor = null;
        maxDepth = 0;
        findAncestorOfDeepest(root, 0);
        return ancestor;
    }
} // O(n) time, O(n) space
  // https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/