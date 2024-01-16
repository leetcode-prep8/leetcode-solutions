class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int p1 = 0, p2 = 0, i1 = 0, i2 = 0;
        while (p1 < encoded1.length && p2 < encoded2.length) {
            int[] a1 = encoded1[p1], a2 = encoded2[p2];
            int count = Math.min(a1[1] - i1, a2[1] - i2);
            int nextVal = a1[0] * a2[0];
            i1 += count;
            i2 += count;
            int nextC = count;
            if (!res.isEmpty() && res.get(res.size() - 1).get(0) == nextVal) {
                nextC += res.get(res.size() - 1).get(1);
                res.remove(res.size() - 1);
            }
            res.add(Arrays.asList(nextVal, nextC));
            // incr pointers, used up either a1 or a2
            if (i2 == a2[1]) {
                p2++;
                i2 = 0;
            }
            if (i1 == a1[1]) {
                p1++;
                i1 = 0;
            }
        }
        return res;
    }
}