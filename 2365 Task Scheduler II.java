package leetcode_solutions;

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> validDay = new HashMap<>();
        long day = 0L;
        for (int i = 0; i < tasks.length; i++) {
            int type = tasks[i];

            // Shortened Solution
            // day += Math.max(validDay.getOrDefault(type, 0L), day) - day + 1;
            // validDay.put(type, day + space);
            if (!validDay.containsKey(type) || validDay.get(type) <= day) {
                day++;
                validDay.put(type, day + space);
            } else {
                long waitCount = validDay.get(type) - day;
                day += waitCount + 1;
                validDay.put(type, day + space);
            }
        }
        return day;
    }
} // O(n) time, O(n) space