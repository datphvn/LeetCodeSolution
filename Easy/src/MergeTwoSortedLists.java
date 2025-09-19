// Định nghĩa ListNode
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Giải pháp chính
class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // nối phần còn lại
        cur.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}

// Class chạy thử
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        // Tạo list1: [1,2,4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // Tạo list2: [1,3,4]
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Gọi hàm
        Solution1 sol = new Solution1();
        ListNode merged = sol.mergeTwoLists(list1, list2);

        // In kết quả
        printList(merged);  // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }

    // Hàm in danh sách
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
