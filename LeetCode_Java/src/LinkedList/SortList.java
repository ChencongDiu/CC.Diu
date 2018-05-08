package LinkedList;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */
public class SortList {
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // cut in half
        ListNode walker = head;
        ListNode runner = head;
        ListNode pre = null;
        while (runner != null && runner.next != null) {
            pre = walker;
            walker = walker.next;
            runner = runner.next.next;
        }
        pre.next = null;
        
        // sort two parts
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(walker);
        
        // merge two parts together
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = merge(l1, l2.next);
            return l2;
        } else {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        
    }
}
