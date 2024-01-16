class Solution { // Pair-row, val. HM<col, PQ<Pair>> 
    // iter minC->maxC
    class Pair {
        int row, val;

        public Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    HashMap<Integer, PriorityQueue<Pair>> map = new HashMap<>();
    int minC = 0, maxC = 0;

    private void traverse(TreeNode n, int row, int col) {
        if (n == null)
            return;
        if (!map.containsKey(col))
            map.put(col, new PriorityQueue<Pair>((a, b) -> a.row == b.row ? a.val - b.val : a.row - b.row));
        map.get(col).offer(new Pair(row, n.val));
        minC = Math.min(minC, col);
        maxC = Math.max(maxC, col);
        traverse(n.left, row + 1, col - 1);
        traverse(n.right, row + 1, col + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, 0, 0);
        for (int i = minC; i <= maxC; i++) {
            PriorityQueue<Pair> pq = map.get(i);
            List<Integer> currList = new ArrayList<>();
            while (!pq.isEmpty())
                currList.add(pq.poll().val);
            res.add(currList);
        }
        return res;
    }
} // O(Nlog(logN)), O(n)