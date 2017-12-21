package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".

 */
public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<> ();
        int[] h = new int[] {1, 2, 4, 8};
        int[] m = new int[] {1, 2, 4, 8, 16, 32};
        for (int i = 0; i <= num; i++) {
            List<Integer> hours = getNumberByDict(h, i);
            List<Integer> minutes = getNumberByDict(m, num - i);
            for (int hour: hours) {
                if (hour >= 12) continue;
                for (int minute: minutes) {
                    if (minute >= 60) continue;
                    res.add(hour + ":" + ((minute < 10)? ("0" + minute): minute));
                }
            }
        }
        return res;
    }
    
    public List<Integer> getNumberByDict(int[] dict, int n) {
        List<Integer> res = new ArrayList<> ();
        backtracking(res, 0, 0, n, dict);
        return res;
    }
    
    public void backtracking(List<Integer> res, int startPos, int sum, int n, int[] dict) {
        if (n == 0) {
            res.add(sum);
            return;
        }
        for (int i = startPos; i < dict.length; i++) {
            backtracking(res, i + 1, sum + dict[i], n - 1, dict);
        }
    }
}
