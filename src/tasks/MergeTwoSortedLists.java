package tasks;

/**
 * Definition for singly-linked list.
 * public class tasks.ListNode {
 *     int val;
 *     tasks.ListNode next;
 *     tasks.ListNode() {}
 *     tasks.ListNode(int val) { this.val = val; }
 *     tasks.ListNode(int val, tasks.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the starting point
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists and compare their nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes of the non-empty list
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        // Return the head of the merged list (next to dummy)
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged = new MergeTwoSortedLists().mergeTwoLists(list1, list2);

        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "tasks.ListNode{" +
                "val=" + val +
                '}';
    }
}