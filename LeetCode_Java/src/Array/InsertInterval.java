package Array;

import java.util.List;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int startIndex = intervals.size();
        for (int i = 0; i < intervals.size(); i++) {
            // find start index
            if (newInterval.start <= intervals.get(i).end) {
                startIndex = i;
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                break;
            }
        }
        for (int i = startIndex; i < intervals.size(); ) {
            if (newInterval.end >= intervals.get(i).start) {
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                intervals.remove(i);
            } else {
                break;
            }
        }
        intervals.add(startIndex, newInterval);
        return intervals;
    }
}
