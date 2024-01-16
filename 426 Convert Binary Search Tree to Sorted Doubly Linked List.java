class Solution {
    //     private void inOrder(Node n) {
    //         if (n == null) return;
    //         inOrder(n.left);
    //         if (head == null && n.left == null) head = n;
    //         if (prev != null) {
    //             prev.right = n;
    //             n.left = prev;
    //         }
    //         prev = n;
    //         inOrder(n.right);
    //     }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node prev = null, head = null;
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (head == null)
                head = curr;
            if (prev != null) {
                prev.right = curr;
                curr.left = prev;
            }
            prev = curr;
            curr = curr.right;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }
}