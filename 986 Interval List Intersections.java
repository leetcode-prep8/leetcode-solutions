class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0)
            return new int[0][];
        List<int[]> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < firstList.length && p2 < secondList.length) {
            if (firstList[p1][0] > secondList[p2][1])
                p2++;
            else if (firstList[p1][1] < secondList[p2][0])
                p1++;
            else {
                res.add(new int[] { Math.max(firstList[p1][0], secondList[p2][0]),
                        Math.min(firstList[p1][1], secondList[p2][1]) });
                if (firstList[p1][1] <= secondList[p2][1])
                    p1++;
                else
                    p2++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }
} // 2pointers, find smaller. overlap when biggerStart < smallerEnd, if no overlap incr smaller