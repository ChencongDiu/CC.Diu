package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
The set [1,2,3,бн,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
        int[] fac = new int[n + 1];
        List<Integer> dict = new ArrayList<> ();
        StringBuilder sb = new StringBuilder();
        
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i;
        }
        for (int i = 1; i <= n; i++) {
            dict.add(i);
        }
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / fac[n - i];
            k %= fac[n - i];
            sb.append(dict.get(index));
            dict.remove(index);
        }
        return sb.toString();
    }
}
