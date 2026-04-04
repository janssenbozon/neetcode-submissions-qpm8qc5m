class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> seen = new Stack<int[]>();
        int[] result = new int[temperatures.length];

        for(int i = 0 ; i <  temperatures.length ; i++) {
            while(!seen.isEmpty() && seen.peek()[1] < temperatures[i]) {
                int[] pair = seen.pop();
                result[pair[0]] = i - pair[0];
            }
            seen.push(new int[]{i, temperatures[i]});
        }

        return result;
    }
}
