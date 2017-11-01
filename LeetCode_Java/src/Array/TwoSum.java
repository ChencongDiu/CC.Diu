package Array;

/*
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int length = nums.length;
        if (length < 2) return res;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = j;
                    res[1] = i;
                    return res;
                }
            }
        }
        return res;
    }
}
