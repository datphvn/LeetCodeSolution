public class PalindromeLinkedList234 {

    public boolean isPalindrome(ListNodePalindromeLinkedList234 head) {
        if (head == null || head.next == null) return true;

        ListNodePalindromeLinkedList234 slow = head;
        ListNodePalindromeLinkedList234 fast = head;

        // Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNodePalindromeLinkedList234 prev = null;
        while (slow != null) {
            ListNodePalindromeLinkedList234 next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Compare
        ListNodePalindromeLinkedList234 left = head;
        ListNodePalindromeLinkedList234 right = prev;

        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList234 solver = new PalindromeLinkedList234();

        // Test 1: [1,2,2,1] -> true
        ListNodePalindromeLinkedList234 head1 =
                new ListNodePalindromeLinkedList234(1,
                        new ListNodePalindromeLinkedList234(2,
                                new ListNodePalindromeLinkedList234(2,
                                        new ListNodePalindromeLinkedList234(1))));

        System.out.println(solver.isPalindrome(head1)); // true

        // Test 2: [1,2] -> false
        ListNodePalindromeLinkedList234 head2 =
                new ListNodePalindromeLinkedList234(1,
                        new ListNodePalindromeLinkedList234(2));

        System.out.println(solver.isPalindrome(head2)); // false
    }
}

class ListNodePalindromeLinkedList234 {
    int val;
    ListNodePalindromeLinkedList234 next;

    ListNodePalindromeLinkedList234() {}

    ListNodePalindromeLinkedList234(int val) {
        this.val = val;
    }

    ListNodePalindromeLinkedList234(int val, ListNodePalindromeLinkedList234 next) {
        this.val = val;
        this.next = next;
    }
}
