package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        Interval intervals[] = new Interval[7];

        // [[12,15], [12,17], [2,4], [16,18], [4,7], [9,11], [1,2]]
        intervals[0] = new Interval(12, 15);
        intervals[1] = new Interval(12, 17);
        intervals[2] = new Interval(2, 4);
        intervals[3] = new Interval(16, 18);
        intervals[4] = new Interval(4, 7);
        intervals[5] = new Interval(9, 11);
        intervals[6] = new Interval(1, 2);

        System.out.print("The merged intervals via stack: ");
        Arrays.mergeIntervals(intervals);

        System.out.print("\nThe merged intervals optimized: ");
        Arrays.mergeIntervalsOptimized(intervals);
    }

}
