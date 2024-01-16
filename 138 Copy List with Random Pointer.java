class Solution {
    // insert copy right after original. then set randoms. then extract
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            if (curr.random != null)
                copy.random = curr.random.next;
            curr = curr.next.next;
        }
        Node headCopy = head.next;
        curr = head;
        Node copy = curr.next;
        while (curr != null && copy != null) {
            if (curr.next.next != null) {
                curr.next = curr.next.next;
                copy.next = copy.next.next;
            } else {
                curr.next = null;
                copy.next = null;
            }
            curr = curr.next;
            copy = copy.next;
        }
        return headCopy;
    }
}