package LinkedList;

/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5


 */
public class ReverseNodesink_Group {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        dummy.next = reverseK(cur.next, k);
        return dummy.next;
    }
    
    public ListNode reverseK(ListNode cur, int k) {
        if (cur == null) return cur;
        ListNode head = cur;
        int count = k;
        while (--k != 0) {
            cur = cur.next;
            if (cur == null) {
                return head;
            }
        }
        //break the list
        ListNode nextHead = cur.next;
        cur.next = null;
        //can be reversed, start to reverse
        ListNode dummyHead = head;
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        dummyHead.next = reverseK(nextHead, count);
        return newHead;
    }
}
