package Array;

import java.util.Arrays;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
 */
public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int index = 0;
        for (Interval i: intervals) {
            start[index] = i.start;
            end[index] = i.end;
            index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 1; i < intervals.length; i++) {
            if (start[i] < end[i - 1]) return false;
        }
        return true;
    }
}
