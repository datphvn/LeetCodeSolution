public class IntersectionOfTwoLinkedLists {

    public ListNodeIntersectionOfTwoLinkedLists getIntersectionNode(
            ListNodeIntersectionOfTwoLinkedLists headA,
            ListNodeIntersectionOfTwoLinkedLists headB) {

        if (headA == null || headB == null) return null;

        ListNodeIntersectionOfTwoLinkedLists pA = headA;
        ListNodeIntersectionOfTwoLinkedLists pB = headB;

        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solver = new IntersectionOfTwoLinkedLists();

        // Tạo danh sách chung (phần giao)
        ListNodeIntersectionOfTwoLinkedLists intersect = new ListNodeIntersectionOfTwoLinkedLists(8);
        intersect.next = new ListNodeIntersectionOfTwoLinkedLists(4);
        intersect.next.next = new ListNodeIntersectionOfTwoLinkedLists(5);

        // List A: 4 -> 1 -> 8 -> 4 -> 5
        ListNodeIntersectionOfTwoLinkedLists headA = new ListNodeIntersectionOfTwoLinkedLists(4);
        headA.next = new ListNodeIntersectionOfTwoLinkedLists(1);
        headA.next.next = intersect;

        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNodeIntersectionOfTwoLinkedLists headB = new ListNodeIntersectionOfTwoLinkedLists(5);
        headB.next = new ListNodeIntersectionOfTwoLinkedLists(6);
        headB.next.next = new ListNodeIntersectionOfTwoLinkedLists(1);
        headB.next.next.next = intersect;

        ListNodeIntersectionOfTwoLinkedLists ans = solver.getIntersectionNode(headA, headB);
        System.out.println(ans != null ? "Intersected at '" + ans.val + "'" : "No intersection");

        // Test 2: không giao nhau
        ListNodeIntersectionOfTwoLinkedLists a1 = new ListNodeIntersectionOfTwoLinkedLists(2);
        a1.next = new ListNodeIntersectionOfTwoLinkedLists(6);
        a1.next.next = new ListNodeIntersectionOfTwoLinkedLists(4);

        ListNodeIntersectionOfTwoLinkedLists b1 = new ListNodeIntersectionOfTwoLinkedLists(1);
        b1.next = new ListNodeIntersectionOfTwoLinkedLists(5);

        ListNodeIntersectionOfTwoLinkedLists ans2 = solver.getIntersectionNode(a1, b1);
        System.out.println(ans2 != null ? "Intersected at '" + ans2.val + "'" : "No intersection");
    }
}

class ListNodeIntersectionOfTwoLinkedLists {
    int val;
    ListNodeIntersectionOfTwoLinkedLists next;
    ListNodeIntersectionOfTwoLinkedLists(int x) {
        val = x;
        next = null;
    }
}
