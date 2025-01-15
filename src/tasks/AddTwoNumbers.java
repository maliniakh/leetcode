package tasks;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-Integer.MIN_VALUE);
        ListNode current = result;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (carry > 0) {
                carry = 0;
            }

            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }

            result.next = new ListNode(sum);

            l1 = l1.next;
            l2 = l2.next;

            result = result.next;
        }

        if (l1 != null || l2 != null) {
            if (l1 != null) {
                result.next = l1;
            } else {
                result.next = l2;
            }
        }

        while (carry > 0) {
            if(result.next == null) {
                result.next = new ListNode(carry);
                break;
            }

            result.next.val += carry;
            if (result.next.val >= 10) {
                result.next.val -= 10;
                result = result.next;
            } else {
                break;
            }
        }

        return current.next;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode createLinkedList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = createLinkedList(new int[]{2, 4, 3});
        ListNode l2 = createLinkedList(new int[]{5, 6, 4});
        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        printLinkedList(result);

        l1 = createLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = createLinkedList(new int[]{9, 9, 9, 9});
        result = new AddTwoNumbers().addTwoNumbers(l1, l2);

        printLinkedList(result);
    }

}
