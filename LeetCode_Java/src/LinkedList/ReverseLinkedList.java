package LinkedList;

/*
Reverse a singly linked list.
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newNode;
            newNode = head;
            head = nextNode;
        }
        return newNode;
    }
}
