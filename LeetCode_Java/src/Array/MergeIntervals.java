package Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval> () {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        int i = 0;
        while (i < intervals.size() - 1) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1);
            if (next.start <= current.end) {
                int end = Math.max(next.end, current.end);
                current.end = end;
                intervals.remove(i + 1);
            } else {
                i++;
            }
        }
        return intervals;
    }
}
