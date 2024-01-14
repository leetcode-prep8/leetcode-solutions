class Solution { // palindrome if oddCount <= 1
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        if (set.size() > 1)
            return false;
        return true;
    }
} // O(n) time O(1) space
  // Other options: HashMap<char, count>, freqCount[]