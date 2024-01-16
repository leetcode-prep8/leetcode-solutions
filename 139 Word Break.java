class Solution {
    class Node {
        Node[] next = new Node[26];
        boolean isWord = false;
    }

    class Trie {
        Node root = new Node();

        public void add(String w) {
            Node curr = root;
            for (char c : w.toCharArray()) {
                if (curr.next[c - 'a'] == null)
                    curr.next[c - 'a'] = new Node();
                curr = curr.next[c - 'a'];
            }
            curr.isWord = true;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie words = new Trie();
        for (String w : wordDict)
            words.add(w);
        Node curr = words.root;
        boolean[] canReach = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || canReach[i - 1]) { // only iter from possible starting points: 0 or i where previous substring is valid
                curr = words.root;
                for (int j = i; j < s.length(); j++) {
                    Node next = curr.next[s.charAt(j) - 'a'];
                    if (next == null)
                        break;
                    curr = next;
                    if (curr.isWord)
                        canReach[j] = true;
                }
            }
        }

        return canReach[s.length() - 1];
    }
}
