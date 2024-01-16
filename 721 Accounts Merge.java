class UnionFind {
    int[] parents;
    int size;
    UnionFind(int size) {
        this.parents = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) parents[i] = i;
    }

    public int find(int i) {
        while (parents[i] != i) i = parents[i];
        return i;
    }

    public void union(int u, int v) {
        parents[find(u)] = find(v); 
        // optimize by merging smaller into larger
    }


}

class Solution {
    HashMap<String, Integer> eGroup = new HashMap<String, Integer>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) { // n acc. max N groups. Each email instantiate to i, but if alr exists union currGroup to existing eGroup, continue iter for any other emails that alr exist union that group w initial existing group
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < accounts.size(); i++) { // i=groupId
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                String e = acc.get(j);
                if (!eGroup.containsKey(e)) eGroup.put(e, i);
                else { // exists, add
                    uf.union(i, eGroup.get(e));
                }
            }
        }
        for (int i = 0; i < n; i++) System.out.println(i + " " + uf.parents[i]);
        HashMap<Integer, List<String>> groups = new HashMap<Integer, List<String>>();
        for (String email : eGroup.keySet()) {
            int parent = uf.find(eGroup.get(email));
            groups.putIfAbsent(parent, new ArrayList<String>());
            groups.get(parent).add(email);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {
            // get name, sort emails
            Collections.sort(entry.getValue());
            String name = accounts.get(entry.getKey()).get(0);
            List<String> emails = entry.getValue();
            emails.add(0, name);
            res.add(emails);
        }
        return res;
    }
}