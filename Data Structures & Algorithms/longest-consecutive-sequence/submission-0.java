class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        for(int i : nums) {
            numbers.add(i);
        }
        int max = 0;
        for(int i : nums) {
            // if start of sequence (no prev) count!
            if(!numbers.contains(i - 1)) {
                int len = 1;
                int cur = i;
                while(numbers.contains(cur + 1)) {
                    len++;
                    cur++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
