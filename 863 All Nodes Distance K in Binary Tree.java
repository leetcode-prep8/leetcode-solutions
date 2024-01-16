class Solution {
    List<Integer> res = new ArrayList<>();

    private int traverse(TreeNode n, TreeNode target, int k, int count) {
        if (n == null)
            return 0;
        if (count == k) {
            res.add(n.val);
            return 0;
        }
        if (n == target) {
            traverse(n.left, target, k, 1);
            traverse(n.right, target, k, 1);
            return 1;
        }
        int left = traverse(n.left, target, k, count > 0 ? count + 1 : count);
        int right = traverse(n.right, target, k, count > 0 ? count + 1 : count);
        if (left == k || right == k) {
            res.add(n.val);
        } else if (left > 0) {
            traverse(n.right, target, k, left + 1);
            return left + 1;
        } else if (right > 0) {
            traverse(n.left, target, k, right + 1);
            return right + 1;
        }
        return 0;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k < 0)
            return res;
        if (k == 0) {
            res.add(target.val);
            return res;
        }
        traverse(root, target, k, 0);
        return res;
    }
}