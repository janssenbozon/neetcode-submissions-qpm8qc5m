class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for(int i : nums) {
            seen.add(i);
        }
        return seen.size() < nums.length;
    }
}