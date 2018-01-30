package LinkedList;

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list.
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        int step = n - m + 1;
        while (m != 1) {
            preNode = preNode.next;
            m--;
        }
        ListNode newNode = null;
        ListNode curNode = preNode.next;
        ListNode tail = curNode;
        while (step != 0) {
            ListNode nextNode = curNode.next;
            curNode.next = newNode;
            newNode = curNode;
            curNode = nextNode;
            step--;
        }
        preNode.next = newNode;
        tail.next = curNode;
        return dummy.next;
    }
}
