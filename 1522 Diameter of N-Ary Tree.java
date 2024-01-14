/*
class Node {
    public int val;
    public List<Node> children;
    public Node() {
        children = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    int diameter;

    private int findDiameter(Node node) {
        if (node == null)
            return 0;
        int maxPath1 = 0;
        int maxPath2 = 0;
        for (Node child : node.children) {
            int path = findDiameter(child);
            if (path > maxPath1) {
                maxPath2 = maxPath1;
                maxPath1 = path;
            } else if (path > maxPath2) {
                maxPath2 = path;
            }
            diameter = Math.max(diameter, maxPath1 + maxPath2);
        }
        return maxPath1 + 1;
    }

    public int diameter(Node root) {
        if (root == null)
            return 0;
        diameter = 0;
        findDiameter(root);
        return diameter;
    }
} // O(N) time, O(N) space