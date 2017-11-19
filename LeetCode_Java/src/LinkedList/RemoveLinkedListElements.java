package LinkedList;

/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = head;
        while (dummy.next != null) {
            if (dummy.next.val == val) dummy.next = dummy.next.next;
            else dummy = dummy.next;
        }
        return (head.val == val)? head.next: head;
    }
}
