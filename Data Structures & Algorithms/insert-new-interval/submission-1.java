class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> solution = new ArrayList<int[]>();

        for(int[] interval : intervals) {
            if(newInterval == null || interval[1] < newInterval[0]) {
                solution.add(interval);
            } else if (interval[0] > newInterval[1]) { 
                solution.add(newInterval);
                solution.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        if (newInterval != null) solution.add(newInterval);
        return solution.toArray(new int[solution.size()][]);
    }
}