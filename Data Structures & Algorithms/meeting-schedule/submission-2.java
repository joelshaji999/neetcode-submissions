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

        if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        System.out.println(intervals.get(0).start);
        System.out.println(intervals.get(0).end);
        System.out.println(intervals.get(1).start);
        System.out.println(intervals.get(1).end);

        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i - 1).end > intervals.get(i).start) {
                return false;
            }
        }

        return true;
    }
}
