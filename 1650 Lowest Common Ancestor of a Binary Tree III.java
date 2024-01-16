class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || q == null)
            return null;
        else if (p == q)
            return p;
        List<Node> pList = new ArrayList<Node>(), qList = new ArrayList<Node>();
        while (p != null || q != null) {
            if (p != null) {
                if (qList.contains(p))
                    return p;
                pList.add(p);
                p = p.parent;
            }
            if (q != null) {
                if (pList.contains(q))
                    return q;
                qList.add(q);
                q = q.parent;
            }
        }
        return null;
    }
}