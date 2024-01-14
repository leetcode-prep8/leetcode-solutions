class Solution {
    int diameter;

    private int findDiameter(TreeNode node) {
        if (node == null)
            return 0;
        int left = findDiameter(node.left);
        int right = findDiameter(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        findDiameter(root);
        return diameter;
    }
} // O(n) O(h)
  // https://leetcode.com/problems/diameter-of-binary-tree/