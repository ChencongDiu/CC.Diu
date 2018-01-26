package LinkedList;

/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curNode = head;
        ListNode preNode = dummy;
        while (curNode != null && curNode.next != null) {
            if (curNode.val != curNode.next.val) {
                preNode = preNode.next;
                curNode = curNode.next;
            } else {
                int num = curNode.val;
                while (curNode != null && curNode.val == num) curNode = curNode.next;
                preNode.next = curNode;
            }
        }
        return dummy.next;
    }
}
