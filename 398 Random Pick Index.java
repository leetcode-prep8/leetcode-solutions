class Solution {
    // HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    int[] nums;
    Random r = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        // for (int i = 0; i < nums.length; i++) {
        //     int n = nums[i];
        //     List<Integer> indices = map.getOrDefault(n, new ArrayList<>());
        //     indices.add(i);
        //     map.putIfAbsent(n, indices);
        // }
    }

    public int pick(int target) {
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (r.nextInt(count) == 0)
                    index = i;
            }
        }
        return index;
        //     List<Integer> list = map.get(target);
        //     int i = (int)(Math.random() * list.size());
        // int i = new Random().nextInt(list.size());
        // return list.get(i);
    }
}