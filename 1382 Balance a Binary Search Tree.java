class Solution {
    private void populateValues(TreeNode curr, List<Integer> values) {
        if (curr == null)
            return;
        populateValues(curr.left, values);
        values.add(curr.val);
        populateValues(curr.right, values);
    }

    private TreeNode createTree(List<Integer> values, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = createTree(values, left, mid - 1);
        node.right = createTree(values, mid + 1, right);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Int
        // eger> values = new ArrayList<Integer>();
        populateValues(root, values);
        return createTree(values, 0, values.size() - 1);
    }
} // O(n) | O(n)
  // https://leetcode.com/problems/balance-a-binary-search-tree/