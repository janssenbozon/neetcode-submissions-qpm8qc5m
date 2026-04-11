class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for(int i : nums) {
            if(seen.contains(i)) {
                return true;
            } else {
                seen.add(i);
            }
        }
        return false;
    }
}