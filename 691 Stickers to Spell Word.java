class Solution {
    // Integer min = null;
    HashMap<String, Integer> memo = new HashMap<>();
    HashMap<String, HashMap<Character, Integer>> sMap = new HashMap<String, HashMap<Character, Integer>>();

    private int dfs(String[] stickers, String s, int count) {
        if (s.length() == 0)
            return 0;
        if (memo.containsKey(s))
            return memo.get(s);

        int res = Integer.MAX_VALUE;
        for (String sticker : sMap.keySet()) {
            HashMap<Character, Integer> cMap = new HashMap(sMap.get(sticker));
            String temp = s;

            char c = temp.charAt(0);
            if (cMap.containsKey(c)) { // use sticker
                for (int i = 0; i < temp.length(); i++) {
                    c = temp.charAt(i);
                    if (cMap.containsKey(c) && cMap.get(c) > 0) {
                        temp = temp.substring(0, i) + temp.substring(i + 1); // creating new string
                        i--;
                        cMap.put(c, cMap.get(c) - 1);
                    }
                }
            }
            if (s.length() != temp.length()) {
                res = Math.min(res, 1 + dfs(stickers, temp, count));
                memo.put(s, res);
            }
        }
        return res;
    }

    public int minStickers(String[] stickers, String target) {
        for (String s : stickers) {
            HashMap<Character, Integer> currMap = new HashMap<Character, Integer>();
            for (char c : s.toCharArray()) {
                if (currMap.containsKey(c))
                    currMap.put(c, currMap.get(c) + 1);
                else
                    currMap.put(c, 1);
            }
            sMap.put(s, currMap);
        }
        int res = dfs(stickers, target, 0);
        return res < 0 || res == Integer.MAX_VALUE ? -1 : res;
    }
}