class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        ListNode head = null;
        if (lists == null || lists.length == 0) {
            return head;
        }
        for (ListNode node : lists) {
            if (node == null)
                continue;
            pq.offer(node);
        }
        if (pq.isEmpty())
            return head;
        head = pq.poll();
        ListNode curr = head;
        if (head.next != null)
            pq.offer(head.next);
        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = nextNode;
            if (nextNode.next != null)
                pq.offer(nextNode.next);
        }
        return head;
    }
}