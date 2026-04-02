/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // sort input
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        // loop through, compare i & i-1
        for(int i = 1 ; i < intervals.size() ; i++) {
            Interval prevMeeting = intervals.get(i - 1);
            Interval currentMeeting = intervals.get(i);

            if(currentMeeting.start < prevMeeting.end) {
                return false;
            }
        }

        return true;
    }
}