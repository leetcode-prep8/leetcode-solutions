class Solution {
    // public class Node {
    //     protected int val;
    //     protected List<Node> neighbors = new ArrayList<>();
    //     protected boolean visited;
    //     protected boolean inPath;
    //     protected Node(int val) {
    //         this.val = val;
    //     }
    // }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }
        List<List<Integer>> adjs = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjs.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];

            indegree[course]++;
            adjs.get(prereq).add(course);
        }
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            list.add(i);
            List<Integer> neighbors = adjs.get(i);
            for (int n : neighbors) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    q.offer(n);
                }
            }
        }
        return list.size() == numCourses;
    }
}