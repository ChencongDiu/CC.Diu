package BinarySearch;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int minIndex = 0, maxIndex = m, halfLen = (m + n + 1) / 2;
        int maxLeft, minRight;
        while (minIndex <= maxIndex) {
            int i = (minIndex + maxIndex) / 2;
            int j = halfLen - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                minIndex = i + 1;
            } else if (i > 0 && nums2[j] < nums1[i - 1]) {
                maxIndex = i - 1;
            } else {
                //here we dont have to do loop any more, we are close to the answer
                //maxLeft
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                
                //even odd checking
                if (((m + n) & 1) == 1) return maxLeft;
                
                //minRight
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return -1;
    }
}
