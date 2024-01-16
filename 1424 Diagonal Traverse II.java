class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            List<Integer> row = nums.get(i);
            count += row.size();
            for (int j = 0; j < row.size(); j++) {
                List<Integer> diag = map.getOrDefault(i + j, new ArrayList<>());
                diag.add(row.get(j));
                map.putIfAbsent(i + j, diag);
            }
        }
        int i = 0;
        int index = 0;
        int[] res = new int[count];
        while (map.containsKey(i)) {
            List<Integer> list = map.get(i++);
            for (int n : list)
                res[index++] = n;
        }
        return res;
    }
}