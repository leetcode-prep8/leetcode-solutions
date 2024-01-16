class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || start.length != 2 || destination.length != 2)
            return false;
        int n = maze.length * maze[0].length;
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[] visited = new boolean[n];
        Queue<Integer> startQ = new LinkedList<Integer>();
        // Queue<Integer> destQ = new LinkedList<Integer>();
        startQ.offer(start[0] * cols + start[1]);
        // destQ.offer(destination[0]*cols + destination[1]);
        // if (start[0] == destination[0] && start[1] == destination[1]) return true;
        int dest = destination[0] * cols + destination[1];
        // System.out.println(dest/cols + " " + dest%cols);
        while (!startQ.isEmpty()) {
            int pos = startQ.poll();
            List<Integer> next = getNext(maze, pos);
            visited[pos] = true;
            for (int i : next) {
                if (!visited[i]) {
                    // System.out.println(i/cols + " " + i%cols);
                    if (i == dest)
                        return true;
                    startQ.offer(i);
                }
            }
        }
        return false;
    }

    private List<Integer> getNext(int[][] maze, int pos) {
        // 4 possible
        int row = pos / maze[0].length;
        int col = pos % maze[0].length;
        List<Integer> list = new ArrayList<>();
        int curr = col;
        while (curr >= 0 && maze[row][curr] == 0) {
            curr--;
        }
        curr++;
        list.add(row * maze[0].length + curr);

        curr = col;
        while (curr < maze[0].length && maze[row][curr] == 0) {
            curr++;
        }
        curr--;
        list.add(row * maze[0].length + curr);

        curr = row;
        while (curr >= 0 && maze[curr][col] == 0) {
            curr--;
        }
        curr++;
        list.add(curr * maze[0].length + col);

        curr = row;
        while (curr < maze.length && maze[curr][col] == 0) {
            curr++;
        }
        curr--;
        list.add(curr * maze[0].length + col);

        return list;
    }
}

// bidirectional bfs O(m*n*(m + n))
// visited[]][]