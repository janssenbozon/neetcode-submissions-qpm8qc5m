class Solution {
    public int subarraySum(int[] nums, int k) {

        // Initiailze seen map
        HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();

        // Empty prefix
        seen.put(0, 1);

        int result = 0;
        int currentSum = 0;
        
        for(int i : nums) {
            currentSum += i;
            result += seen.getOrDefault(currentSum - k, 0);
            seen.put(currentSum, seen.getOrDefault(currentSum, 0) + 1);
        }
        return result;
    }
}