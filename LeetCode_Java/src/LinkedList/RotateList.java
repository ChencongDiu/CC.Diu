package LinkedList;

/*
Given a list, rotate the list to the right by k places, where k is non-negative.


Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode tail = dummy;
        //get length, head will point to null
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        //real k
        k %= len;
        if (k == 0) return dummy.next;
        //move cur position
        for (int i = 0; i < len - k; i++) {
            cur = cur.next;
        }
        //rotate and reconstruct
        tail.next = dummy.next;
        dummy.next = cur.next;
        cur.next = null;
        return dummy.next;
    }
}
