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
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head
                ;

        while (current != null) {
            ListNode nextTemp = current.next; // Store the next node
            current.next = prev;             // Reverse the link
            prev = current;                  // Move prev to current
            current = nextTemp;              // Move current to next
        }

        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode reversed = new ReverseLinkedList().reverseList(list);

        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}


