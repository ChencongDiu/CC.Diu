package BinarySearch;

/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class HIndexII {
	public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = citations.length - mid;
            if (citations[mid] == h) return citations[mid];
            else if (citations[mid] < h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return citations.length - left;
    }
}
