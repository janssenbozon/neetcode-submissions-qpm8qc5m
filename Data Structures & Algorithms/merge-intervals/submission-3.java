class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        if(intervals.length == 1) {
            return intervals;
        }

        int i = 1;
        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];
        while(i < intervals.length) {
            int curIntervalStart = intervals[i][0];
            int curIntervalEnd = intervals[i][1];
            if(curEnd >= curIntervalStart) {
                curEnd = Math.max(curEnd, curIntervalEnd);
            } else {
                res.add(new int[]{curStart, curEnd});
                curStart = curIntervalStart;
                curEnd = curIntervalEnd;
            }
            i++;
        }

        res.add(new int[]{curStart, curEnd});
        return res.toArray(new int[res.size()][]);
    }
}
