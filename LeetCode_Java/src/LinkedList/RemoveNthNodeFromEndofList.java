package LinkedList;

/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
   
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode dummy = pre;
        ListNode walker = head;
        ListNode runner = head;
        while (n != 0) {
            runner = runner.next;
            n--;
        }
        while (runner != null) {
            pre = pre.next;
            walker = walker.next;
            runner = runner.next;
        }
        pre.next = walker.next;
        return dummy.next;
    }
}
