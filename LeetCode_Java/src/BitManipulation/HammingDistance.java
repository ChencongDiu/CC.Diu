package BitManipulation;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ¡Ü x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ¡ü   ¡ü

The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
	public static int hammingDistance(int x, int y) {
		/*int result = 0;
		String strx = Integer.toBinaryString(x);
		String stry = Integer.toBinaryString(y);
		strx = ("00000000000000000000000000000000" + strx).substring(strx.length());
		stry = ("00000000000000000000000000000000" + stry).substring(stry.length());
		for (int i = 0; i < 32; i++) {
			if (strx.charAt(i) != stry.charAt(i))
				result++;
		}
		
		return result;*/
		
		//return Integer.bitCount(x ^ y);
        int z = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += ((z >> i) & 1);
        }
        return res;
    }
}
