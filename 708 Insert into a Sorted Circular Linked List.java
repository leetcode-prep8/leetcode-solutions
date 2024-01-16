class Solution {
    private void insertNode(Node curr, Node insert) {
        insert.next = curr.next;
        curr.next = insert;
    }

    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        if (head == null) {
            n.next = n;
            return n;
        }
        if (head.next == head) {
            insertNode(head, n);
            return head;
        }
        Node prev = head;
        Node curr = head.next;
        do {
            if (curr.val < prev.val) { // head and tail
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    insertNode(prev, n);
                    return head;
                }
            } else if (insertVal >= prev.val && insertVal < curr.val) {
                insertNode(prev, n);
                return head;
            }
            prev = curr;
            curr = curr.next;
        } while (prev != head);
        insertNode(prev, n); // handle all duplicate
        return head;
    }
}