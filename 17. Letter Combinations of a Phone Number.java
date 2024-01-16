class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        String[] map = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        Queue<StringBuilder> q = new LinkedList<StringBuilder>();
        for (char c : digits.toCharArray()) {
            if (c == '0' || c == '1')
                continue;
            if (q.size() == 0) {
                for (char add : map[c - '0'].toCharArray())
                    q.offer(new StringBuilder().append(add));
            } else {
                int size = q.size();
                String letters = map[c - '0'];
                for (int i = 0; i < size; i++) {
                    StringBuilder s = q.poll();
                    for (char add : letters.toCharArray())
                        q.offer(new StringBuilder(s).append(add));
                }
            }
        }
        // return q.stream().map(s -> s.toString()).collect(Collectors.toList());
        List<String> res = new ArrayList<>();
        for (StringBuilder s : q)
            res.add(s.toString());
        return res;
    }
}