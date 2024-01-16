class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Solution 1
        // if (nums.length == 0) return new int[0];
        // HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        // for (int n : nums) {
        //     counts.put(n, counts.getOrDefault(n, 0) + 1);
        // }
        // List<Integer>[] countBuckets = new List[nums.length];
        // for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
        //     int index = entry.getValue() - 1;
        //     List<Integer> bucket = countBuckets[index];
        //     if (bucket == null) {
        //         countBuckets[index] = new ArrayList<Integer>(Arrays.asList(entry.getKey()));
        //     } else {
        //         countBuckets[index].add(entry.getKey());
        //     }
        // }
        // int count = 0;
        // int[] result = new int[k];
        // for (int i = nums.length - 1; i >= 0; i--) {
        //     List<Integer> bucket = countBuckets[i];
        //     if (bucket != null) {
        //         if (count >= k) break;
        //         for (Integer num: bucket) {
        //             result[count] = num;
        //             count++;
        //         }
        //     }
        // }
        // return result;

        // Solution 2
        if (nums.length == 0)
            return new int[0];
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> topCounts = new PriorityQueue<>((a, b) -> counts.get(a) - counts.get(b));
        for (int n : counts.keySet()) {
            if (topCounts.size() < k) {
                topCounts.offer(n);
            } else if (counts.get(n) > counts.get(topCounts.peek())) {
                topCounts.poll();
                topCounts.offer(n);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topCounts.poll();
        }
        return res;
    }
}