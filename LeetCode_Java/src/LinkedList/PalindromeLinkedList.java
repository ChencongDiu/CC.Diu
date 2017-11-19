package LinkedList;

/*
Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if (head == null)   return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        slow = slow.next;
        
        slow = reverse(slow);
        fast = head;
        
        while (slow != null) {
        	if (slow.val != fast.val)	return false;
	        fast = fast.next;
	        slow = slow.next;
        }
        return true;
    }

	private ListNode reverse(ListNode slow) {
		ListNode prev = null;
		while (slow != null) {
			ListNode next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;
		}
		return prev;
	}
}
