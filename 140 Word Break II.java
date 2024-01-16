class Solution { // O(2^(N-1)) | O(N) (max recurs if not inc res space)
    class Node {
        Node[] next = new Node[26];
        boolean isWord = false;
    }

    class Trie {
        Node root = new Node();

        public void add(String w) {
            Node curr = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (curr.next[i] == null)
                    curr.next[i] = new Node();
                curr = curr.next[i];
            }
            curr.isWord = true;
        }
    }

    List<String> res = new ArrayList<>();

    public void construct(String s, StringBuilder temp, Node prev, Trie words, int i) {
        if (i >= s.length() || prev.next[s.charAt(i) - 'a'] == null)
            return;

        Node curr = prev.next[s.charAt(i) - 'a'];
        temp.append(s.charAt(i));
        if (curr.isWord) {
            if (i == s.length() - 1) {
                if (curr.isWord)
                    res.add(temp.toString());
                temp.deleteCharAt(temp.length() - 1);
                return;
            } else {
                temp.append(' ');
                construct(s, temp, words.root, words, i + 1);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
        construct(s, temp, curr, words, i + 1);
        temp.deleteCharAt(temp.length() - 1);

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie words = new Trie();
        for (String w : wordDict)
            words.add(w);
        construct(s, new StringBuilder(), words.root, words, 0);
        return res;
    }
}