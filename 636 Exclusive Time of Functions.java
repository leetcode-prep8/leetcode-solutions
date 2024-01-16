class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prevTime = -1;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (String s : logs) {
            String[] info = s.split(":"); // [id, start/end, timestamp]
            int id = Integer.parseInt(info[0]);
            if (info[1].equals("start")) {
                int startTime = Integer.parseInt(info[2]);
                if (prevTime != -1 && !stack.isEmpty())
                    res[stack.peek()] += startTime - prevTime; // e.g. 3 - 2 = 1
                prevTime = startTime;
                stack.push(id);
            } else {
                int endTime = Integer.parseInt(info[2]);
                res[id] += endTime - prevTime + 1; // e.g. 3 - 2 + 1 = 2
                prevTime = endTime + 1;
                stack.pop();
            }
        }
        return res;
    }
}