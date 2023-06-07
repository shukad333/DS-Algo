package greedy;


import java.util.Arrays;
import java.util.function.Consumer;

class MeetingRooms2 {

    public static void main(String[] args) {

        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(1,2);
        intervals[1] = new Interval(2,3);
        intervals[2] = new Interval(4,5);

        int reps= new MeetingRooms2().minMeetingRooms(intervals);
        System.out.println(reps);

    }

    /**
     *
     *
     * [[1,10],[2,8],[3,5]]
     *
     * start = [1,2,3]
     * end  = [5,8,10]
     *
     *
     * [[1,10],[20,30],[40,50]]
     *
     * start = [1,20,40]
     * end = [10,30,50]
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        System.out.println(Arrays.toString(starts));
        System.out.println(Arrays.toString(ends));
        int rooms = 0, endsItr = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsItr]) {
                rooms++;
            } else {
                endsItr++;
            }
        }
        return rooms;
    }
}

class Interval {

    int start,end;
    public Interval(int start,int end) {
        this.start = start;
        this.end = end;
    }
}