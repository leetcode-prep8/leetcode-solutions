class Solution {
    List<Integer> res = new ArrayList<>(); // Recursive – O(n) | O(h)

    private void recurse(TreeNode n, int level) {
        if (n == null)
            return;
        if (level > res.size())
            res.add(n.val);
        recurse(n.right, level + 1);
        recurse(n.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return res;
        recurse(root, 1);
        return res;
    }
}