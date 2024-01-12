class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        int minLevel = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSum = 0;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode currNode = queue.poll();
                levelSum += currNode.val;
                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
    }
} // O(n) time, O(n) space
  // https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/