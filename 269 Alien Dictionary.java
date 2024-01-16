class Solution { // Kahn's - Adj list <Char, <List<Char>>, Queue, indegree count HM<Char, Integer>

    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> edges = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                edges.putIfAbsent(c, new ArrayList<Character>());
                indegree.putIfAbsent(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) { // add edges
            String w1 = words[i];
            String w2 = words[i + 1];
            if (w1.startsWith(w2) && w1.length() > w2.length()) return "";
            for (int j = 0; j < w1.length(); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    char origin = w1.charAt(j);
                    char neighbor = w2.charAt(j);
                    if (!edges.get(origin).contains(neighbor)) {
                        edges.get(origin).add(neighbor);
                        indegree.put(neighbor, indegree.get(neighbor) + 1);
                    }
                    break;
                }
            }
            // look for first diff char. if we run out of chars then one is prefix of other. w2 can't be prefix. if w1 is prefix no edge to add
        }
        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            res.append(c);
            for (char neighbor : edges.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }
        if (res.length() == edges.size()) return res.toString();
        return "";
    }
    
}