class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null)
                    return depth;
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
        }
        return depth;
    }
} // Iterative O(logn) O(N)
  // https://leetcode.com/problems/minimum-depth-of-binary-tree/