package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MeetingRooms_252 {
    public class Interval implements Comparable<Interval> {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }

    MeetingRooms_252 meetingRooms;
    Interval[] intervals;

    @BeforeEach
    public void init() {
        meetingRooms = new MeetingRooms_252();
        /*intervals = new Interval[3];
        intervals[0] = new Interval(5, 10);
        intervals[1] = new Interval(0, 30);
        intervals[2] = new Interval(15, 20);*/
        intervals = new Interval[2];
        intervals[0] = new Interval(7, 10);
        intervals[1] = new Interval(2, 4);

        Arrays.sort(intervals);
    }

    @Test
    public void testFirs() {
        //boolean res= meetingRooms.canAttendMeetings(intervals);
        //Assertions.assertEquals(false,res);
        boolean res= meetingRooms.canAttendMeetings(intervals);
        Assertions.assertEquals(true,res);

    }

    private boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        System.out.println(intervals.length);
        if(intervals.length==1) return true;
        for (int i = 1; i <intervals.length ; i++) {
            if (intervals[i].start < intervals[i - 1].end)
                return false;
        }
        return true;

    }
}
