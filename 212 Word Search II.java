class Solution {
    Set<String> foundWords;
    int maxWordLength;

    class TrieNode {
        TrieNode[] neighbors = new TrieNode[26];
        boolean isWord = false;
        String word = "";
        public TrieNode() {}
    }
    private void addWord(TrieNode root, String word) {
        if (root == null) return;
        TrieNode curr = root;
        for (char c : word.toCharArray()) { // I see this commonly - is single character variable acceptable?
            TrieNode next = curr.neighbors[c - 'a'];
            if (next == null) {
                next = new TrieNode();
                curr.neighbors[c - 'a'] = next;
            }
            curr = next;
        }
        curr.isWord = true;
        curr.word = word;
    }
    private void addWords(char[][] board, int i, int j, TrieNode node, int length) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == 'X' || length > maxWordLength) return;
        char currChar = board[i][j];
        TrieNode next = node.neighbors[currChar - 'a'];
        if (next == null) return;
        board[i][j] = 'X';
        length++;
        if (next.isWord) {
            foundWords.add(next.word);
        }

        addWords(board, i - 1, j, next, length);
        addWords(board, i + 1, j, next, length);
        addWords(board, i, j - 1, next, length);
        addWords(board, i, j + 1, next, length);

        board[i][j] = currChar;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        foundWords = new HashSet<String>();
        maxWordLength = 0;
        for (String word : words) {
            addWord(root, word);
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                addWords(board, i, j, root, 0);
            }
        }
        return new ArrayList<String>(foundWords);
    }
}// O((mn)^2) time, O(max(words*length, mn)) space
// https://leetcode.com/problems/word-search-ii/description/
