class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rootList = new ArrayList<Integer>();
        if (n == 0)
            return rootList;
        else if (n == 1) {
            rootList.add(0);
            return rootList;
        }
        HashMap<Integer, HashSet<Integer>> edgeMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            edgeMap.put(i, new HashSet<Integer>());
        for (int[] edge : edges) {
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (Map.Entry<Integer, HashSet<Integer>> entry : edgeMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                leaves.add(entry.getKey());
            }
        }
        int count = n;
        count -= leaves.size();
        while (count > 0) {
            List<Integer> nextLeaves = new ArrayList<>();
            for (int leaf : leaves) { // leaf only has 1 neighbor
                int neighbor = edgeMap.get(leaf).iterator().next();
                edgeMap.get(neighbor).remove(leaf);
                if (edgeMap.get(neighbor).size() == 1) {
                    nextLeaves.add(neighbor);
                }
            }
            leaves = nextLeaves;
            count -= leaves.size();
        }
        for (int centroid : leaves)
            rootList.add(centroid);
        return rootList;
    }
} // O(N) time, O(N) space