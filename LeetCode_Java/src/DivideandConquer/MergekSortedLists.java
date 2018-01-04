package DivideandConquer;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

/*
 * time complexity: nklogk, where n is average number of nodes of a list, k is number of list
 * For this divide and conquer methods,
 * 1st loop: k lists, n nodes/list, we have to merge them in O(kn)
 * 2nd loop: k/2 lists, 2n nodes/list, we have to merge them in O(kn)
 * 3rd loop: k/4 lists, 4n nodes/list, we have to merge them in O(kn)
 * ...
 * logkth loop: 2 list, nk/2 nodes/list, we have to merge them in O(kn)
 */

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        return divideConquer(lists, 0, lists.length - 1);
    }
    
    public ListNode divideConquer(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start < end) {
            int mid = (start + end) >>> 1;
            ListNode l1 = divideConquer(lists, start, mid);
            ListNode l2 = divideConquer(lists, mid + 1, end);
            return mergeTwoSortedLists(l1, l2);
        }
        return null;
    }
    
    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedLists(l2.next, l1);
            return l2;
        }
    }
}
