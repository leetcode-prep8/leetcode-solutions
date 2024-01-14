class Solution {
    class Pair {
        int sum = 0;
        int count = 0;
        public Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    int averageCount;
    private Pair findAverageNodes(TreeNode node) {
        if (node == null) return new Pair(0, 0);
        Pair left = findAverageNodes(node.left);
        Pair right = findAverageNodes(node.right);
        double sum = left.sum + right.sum + node.val;
        int count = left.count + right.count + 1;
        if (count != 0 && node.val == (int)Math.floor(sum / count)) averageCount++;
        return new Pair((int)sum, count);
    }
    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        averageCount = 0; 
        findAverageNodes(root);
        return averageCount;
    }
} // O(n) time O(n) space