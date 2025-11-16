public class ReverseLinkedList {

    // Iterative
    public ListNodeReverseLinkedList reverseList(ListNodeReverseLinkedList head) {
        ListNodeReverseLinkedList prev = null;
        ListNodeReverseLinkedList curr = head;

        while (curr != null) {
            ListNodeReverseLinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Recursive
    public ListNodeReverseLinkedList reverseListRecursive(ListNodeReverseLinkedList head) {
        if (head == null || head.next == null)
            return head;

        ListNodeReverseLinkedList newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList solver = new ReverseLinkedList();

        // Test 1: [1,2,3,4,5]
        ListNodeReverseLinkedList head1 =
                new ListNodeReverseLinkedList(1,
                        new ListNodeReverseLinkedList(2,
                                new ListNodeReverseLinkedList(3,
                                        new ListNodeReverseLinkedList(4,
                                                new ListNodeReverseLinkedList(5)))));

        printList(solver.reverseList(head1));  // 5 4 3 2 1

        // Test 2: [1,2]
        ListNodeReverseLinkedList head2 =
                new ListNodeReverseLinkedList(1, new ListNodeReverseLinkedList(2));

        printList(solver.reverseListRecursive(head2)); // 2 1

        // Test 3: []
        printList(solver.reverseList(null)); // empty
    }

    public static void printList(ListNodeReverseLinkedList head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class ListNodeReverseLinkedList {
    int val;
    ListNodeReverseLinkedList next;

    ListNodeReverseLinkedList() {}

    ListNodeReverseLinkedList(int val) {
        this.val = val;
    }

    ListNodeReverseLinkedList(int val, ListNodeReverseLinkedList next) {
        this.val = val;
        this.next = next;
    }
}
