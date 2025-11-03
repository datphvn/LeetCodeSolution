public class RemoveLinkedListElements {

    // Hàm xóa node có giá trị val
    public ListNodeRemoveLinkedListElements removeElements(ListNodeRemoveLinkedListElements head, int val) {
        ListNodeRemoveLinkedListElements dummy = new ListNodeRemoveLinkedListElements(0);
        dummy.next = head;
        ListNodeRemoveLinkedListElements curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return dummy.next;
    }

    // Hàm in danh sách liên kết
    public static void printList(ListNodeRemoveLinkedListElements head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // --- MAIN TEST ---
    public static void main(String[] args) {
        RemoveLinkedListElements solver = new RemoveLinkedListElements();

        // Test 1
        System.out.println("Test 1:");
        ListNodeRemoveLinkedListElements head1 = new ListNodeRemoveLinkedListElements(1,
                new ListNodeRemoveLinkedListElements(2,
                        new ListNodeRemoveLinkedListElements(6,
                                new ListNodeRemoveLinkedListElements(3,
                                        new ListNodeRemoveLinkedListElements(4,
                                                new ListNodeRemoveLinkedListElements(5,
                                                        new ListNodeRemoveLinkedListElements(6)))))));
        ListNodeRemoveLinkedListElements result1 = solver.removeElements(head1, 6);
        printList(result1); // expected: 1 2 3 4 5

        // Test 2
        System.out.println("Test 2:");
        ListNodeRemoveLinkedListElements result2 = solver.removeElements(null, 1);
        printList(result2); // expected: (empty)

        // Test 3
        System.out.println("Test 3:");
        ListNodeRemoveLinkedListElements head3 = new ListNodeRemoveLinkedListElements(7,
                new ListNodeRemoveLinkedListElements(7,
                        new ListNodeRemoveLinkedListElements(7,
                                new ListNodeRemoveLinkedListElements(7))));
        ListNodeRemoveLinkedListElements result3 = solver.removeElements(head3, 7);
        printList(result3); // expected: (empty)
    }
}

// --- Class node  ---
class ListNodeRemoveLinkedListElements {
    int val;
    ListNodeRemoveLinkedListElements next;
    ListNodeRemoveLinkedListElements() {}
    ListNodeRemoveLinkedListElements(int val) { this.val = val; }
    ListNodeRemoveLinkedListElements(int val, ListNodeRemoveLinkedListElements next) {
        this.val = val;
        this.next = next;
    }
}
