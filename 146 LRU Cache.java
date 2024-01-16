class LRUCache {
    HashMap<Integer, Node> nodeMap = new HashMap<>();
    Node head, tail;
    int capacity;

    class Node {
        Node next;
        Node prev;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addTail(Node n) {
        Node currTail = tail.prev;
        currTail.next = n;
        n.prev = currTail;
        n.next = tail;
        tail.prev = n;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key))
            return -1;
        Node n = nodeMap.get(key);
        remove(n);
        addTail(n);
        return n.val;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node n = nodeMap.get(key);
            remove(n);
        }
        Node n = new Node(key, value);
        nodeMap.put(key, n);
        addTail(n);
        if (nodeMap.size() > capacity) {
            Node currHead = head.next;
            remove(currHead);
            nodeMap.remove(currHead.key);
        }
    }
}
// get O(1) – get from map, move to Tail
// put O(1) – put in map. put after tail. remove head if capacity