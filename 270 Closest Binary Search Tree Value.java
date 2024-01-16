class Solution {
    public int closestValue(TreeNode root, double target) {
        // O(logn) O(1)
        TreeNode curr = root;
        double minDiff = Math.abs(root.val - target);
        double closest = root.val;
        while (curr != null) {
            double diff = Math.abs(target - curr.val);
            if (diff == minDiff) {
                closest = Math.min(closest, curr.val);
            } else if (diff < minDiff) {
                minDiff = diff;
                closest = curr.val;
            }
            if (curr.val == target)
                return curr.val;
            else if (curr.val > target)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return (int) closest;
    }
}