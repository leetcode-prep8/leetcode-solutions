class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0)
            return num2;
        else if (num2 == null || num2.length() == 0)
            return num1;
        StringBuilder res = new StringBuilder();
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        boolean carry = false;
        while (p1 >= 0 || p2 >= 0) {
            int digit = 0;
            if (p1 >= 0)
                digit += (int) (num1.charAt(p1--) - '0');
            if (p2 >= 0)
                digit += (int) (num2.charAt(p2--) - '0');
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
            if (carry)
                digit += 1;
            if (digit > 9) {
                carry = true;
                digit %= 10;
            } else
                carry = false;
            res.insert(0, digit);
        }
        if (carry)
            res.insert(0, '1');
        return res.toString();
    }
}