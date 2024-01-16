class Solution { // down from p find q, q find p, then down from root return if in subtree
    TreeNode ancestor = null;

    private boolean findFrom(TreeNode n, TreeNode target) {
        if (n == null)
            return false;
        if (n == target)
            return true;
        return findFrom(n.left, target) || findFrom(n.right, target);
    }

    private boolean findTwo(TreeNode n, TreeNode p, TreeNode q) {
        if (n == null)
            return false;
        if (n == p || n == q)
            return true;
        boolean left = findTwo(n.left, p, q);
        boolean right = findTwo(n.right, p, q);
        if (left && right) {
            ancestor = n;
            return true;
        }
        return left || right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        if (p == root || q == root)
            return root;
        if (p == q)
            return p;
        boolean isPAncestor = findFrom(p, q);
        if (isPAncestor)
            return p;
        boolean isQAncestor = findFrom(q, p);
        if (isQAncestor)
            return q;
        findTwo(root, p, q);
        return ancestor;
    }
}