class Solution {
    private String getBaseForm(String s) {
        int diff = s.charAt(0) - 'a';
        StringBuilder res = new StringBuilder();
        // for (int i = 0; i < s.length(); i++) { // Base Form: subtracting diff to each char so first char becomes a. 

        //     int c = (s.charAt(i) - diff + 26) % 26; // [0 ~ 25]
        //     res.append((char)c);
        // }
        for (int i = 1; i < s.length(); i++) { // Base Form 2: diff btwn each succ char
            int c = (s.charAt(i) - s.charAt(i - 1) + 26) % 26; // [0 ~ 25]
            res.append((char) (c + 'a'));
        }
        return res.toString();
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String base = getBaseForm(s);
            List<String> list = map.getOrDefault(base, new ArrayList<>());
            list.add(s);
            map.putIfAbsent(base, list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet())
            res.add(entry.getValue());
        return res;
    }
}