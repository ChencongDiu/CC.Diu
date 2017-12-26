package BinarySearch;

/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
ก่
ก่ ก่
ก่ ก่

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
ก่
ก่ ก่
ก่ ก่ ก่
ก่ ก่

Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {
	public int arrangeCoins(int n) {
        int l = 0, h = n;
        while (l <= h) { //l == h == right answer, then the last loop will do l = l + 1
            int mid = (l + h) >>> 1;
            //mid is the answer
            if ((0.5 * mid * mid + 0.5 * mid) == n) {
                return mid;
            } else if ((0.5 * mid * mid + 0.5 * mid ) < n) {
                l = mid + 1; //too small, but may be the answer
            } else {
                h = mid - 1; //too large
            }
        }
        return l - 1;
    }
}
