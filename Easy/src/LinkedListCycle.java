public class LinkedListCycle {
    public boolean hasCycleTwoPointers(ListNodeLinkedListCycle head) {
        if (head == null || head.next == null) return false;
        ListNodeLinkedListCycle slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public boolean hasCycleHashSet(ListNodeLinkedListCycle head) {
        java.util.Set<ListNodeLinkedListCycle> seen = new java.util.HashSet<>();
        while (head != null) {
            if (seen.contains(head)) return true;
            seen.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solver = new LinkedListCycle();

        // Test 1: [3,2,0,-4], pos = 1 → true
        ListNodeLinkedListCycle n1 = new ListNodeLinkedListCycle(3);
        ListNodeLinkedListCycle n2 = new ListNodeLinkedListCycle(2);
        ListNodeLinkedListCycle n3 = new ListNodeLinkedListCycle(0);
        ListNodeLinkedListCycle n4 = new ListNodeLinkedListCycle(-4);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n2; // cycle
        System.out.println(solver.hasCycleTwoPointers(n1)); // true
        System.out.println(solver.hasCycleHashSet(n1));     // true

        // Test 2: [1,2], pos = 0 → true
        ListNodeLinkedListCycle a1 = new ListNodeLinkedListCycle(1);
        ListNodeLinkedListCycle a2 = new ListNodeLinkedListCycle(2);
        a1.next = a2; a2.next = a1;
        System.out.println(solver.hasCycleTwoPointers(a1)); // true

        // Test 3: [1], pos = -1 → false
        ListNodeLinkedListCycle b1 = new ListNodeLinkedListCycle(1);
        System.out.println(solver.hasCycleTwoPointers(b1)); // false
    }
}

class ListNodeLinkedListCycle {
    int val;
    ListNodeLinkedListCycle next;
    ListNodeLinkedListCycle(int val) { this.val = val; }
}
