class Solution {
    private void populateRoute(List<String> route, HashMap<String, PriorityQueue<String>> neighbors, String airport) {
        PriorityQueue<String> currNeighbors = neighbors.get(airport);
        while (currNeighbors != null && !currNeighbors.isEmpty()) {
            populateRoute(route, neighbors, currNeighbors.poll());
        }
        route.add(airport);
        return;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> neighbors = new HashMap<String, PriorityQueue<String>>();
        for (List<String> ticket : tickets) {
            neighbors.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
            neighbors.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> route = new ArrayList<String>();
        String origin = "JFK";
        populateRoute(route, neighbors, origin);
        Collections.reverse(route);
        return route;
    }
} // O(Elog(E)) time, O(E + V) space

// Eularian path - path visiting every edge once
// Hierholzer's Algorithm: start random, visit until back at start. All visited? Done. Else, choose another node with edge remaining and visit. Repeat. This finds the Eularian path.