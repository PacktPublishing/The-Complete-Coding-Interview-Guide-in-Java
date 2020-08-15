package coding.challenge;
 
import java.util.Comparator;
import java.util.Stack;

public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* O(n log n) runtime and O(n) auxiliary space */
    public static void mergeIntervals(Interval[] intervals) {

        if (intervals == null) {
            throw new IllegalArgumentException("The given array of intervals cannot be null");
        }

        // sort the given intervals in ascending order based on their starts
        java.util.Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Stack<Interval> stackOfIntervals = new Stack();

        for (Interval interval : intervals) {

            // push the first interval into the stack or
            // if the current interval does not overlap with interval 
            // from the top of the stack then push it into the stack
            if (stackOfIntervals.empty() || interval.start > stackOfIntervals.peek().end) {
                stackOfIntervals.push(interval);
            }

            // if the current interval overlaps with the interval from 
            // the top of the stack and the end of the current interval 
            // is greater than that of the stack top then update the stack 
            // top with the end of the current interval
            if (stackOfIntervals.peek().end < interval.end) {
                stackOfIntervals.peek().end = interval.end;
            }
        }

        // print the result
        while (!stackOfIntervals.empty()) {
            System.out.print(stackOfIntervals.pop() + " ");
        }
    }

    /* O(n log n) runtime and O(1) auxiliary space */
    public static void mergeIntervalsOptimized(Interval intervals[]) {
        if (intervals == null) {
            throw new IllegalArgumentException("The given array of intervals cannot be null");
        }

        // sort the given intervals in descending order of their starts
        java.util.Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i2.start - i1.start;
            }
        });

        int index = 0;

        for (int i = 0; i < intervals.length; i++) {

            // check if this is not the first interval and overlaps with the previous one  
            if (index != 0 && intervals[index - 1].start <= intervals[i].end) {
                while (index != 0 && intervals[index - 1].start <= intervals[i].end) {

                    // merge the previous interval with the current interval  
                    intervals[index - 1].end = Math.max(intervals[index - 1].end, intervals[i].end);
                    intervals[index - 1].start = Math.min(intervals[index - 1].start, intervals[i].start);
                    index--;
                }
                // there is no overlap with the previous interval
            } else {
                intervals[index] = intervals[i];
            }

            index++;
        }

        // print the result        
        for (int i = 0; i < index; i++) {
            System.out.print(intervals[i] + " ");
        }
    }
}
