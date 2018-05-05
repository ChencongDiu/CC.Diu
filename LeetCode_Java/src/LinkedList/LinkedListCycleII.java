package LinkedList;

/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?


 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode walker = head;
        ListNode runner = head;
        boolean hasCycle = false;
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        ListNode finder = head;
        while (finder != walker) {
            finder = finder.next;
            walker = walker.next;
        }
        return finder;
    }
}
