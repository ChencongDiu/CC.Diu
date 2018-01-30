package LinkedList;

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode curNode1 = dummy1, curNode2 = dummy2;
        
        while (head != null) {
            if (head.val < x) {
                curNode1.next = head;
                curNode1 = curNode1.next;
            } else {
                curNode2.next = head;
                curNode2 = curNode2.next;
            }
            head = head.next;
        }
        curNode2.next = null;
        curNode1.next = dummy2.next;
        return dummy1.next;
    }
}
