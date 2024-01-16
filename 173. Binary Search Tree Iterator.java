class BSTIterator {
    // Queue<Integer> q = new LinkedList<Integer>();
    int prevVal = Integer.MIN_VALUE;

    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    public int next() {
        TreeNode curr = stack.pop();
        int val = curr.val;
        if (curr.right != null) {
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}