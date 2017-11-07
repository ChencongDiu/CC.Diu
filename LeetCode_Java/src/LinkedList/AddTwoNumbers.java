package LinkedList;

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

/*
 * TC O(n), SC O(n)
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); //to be operated
        ListNode result = head; //to be returned
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l1 == null)? 0: l1.val) + ((l2 == null)? 0: l2.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            head.next = cur;
            head = cur;
            
            l1 = (l1 == null)? l1: l1.next;
            l2 = (l2 == null)? l2: l2.next;
        }
        return result.next;
    }
}
