class Solution { // O(4(n-m)) | O(n-m)
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // up right down left
    Set<Pair<Integer, Integer>> set = new HashSet<Pair<Integer, Integer>>();
    Robot robot;

    private void reset() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    // backtrack. go to unvisited. once all visited go back by turning 
    private void backtrack(int x, int y, int dir) { // up right down left
        // System.out.println(x + " " + y);
        Pair curr = new Pair(x, y);
        if (!set.contains(curr)) {
            robot.clean();
            set.add(curr);
        }
        for (int i = dir; i < dir + dirs.length; i++) {
            int newR = x + dirs[i % 4][0], newC = y + dirs[i % 4][1];
            if (!set.contains(new Pair(newR, newC)) && robot.move()) {
                backtrack(newR, newC, i % 4);
                reset();
            } // try curr dir, then next next next. Once completed, facing initial dir. we return to prev recursive call, which resets robot.
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
}