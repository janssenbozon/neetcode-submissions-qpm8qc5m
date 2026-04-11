class Solution {
    List<List<Integer>> sets;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        sets = new ArrayList<>();
        buildSubset(new ArrayList<Integer>(), 0);
        return sets;
    }

    public void buildSubset(List<Integer> set, int i) {
        if(i == nums.length) {
            sets.add(new ArrayList<>(set));
            return;
        }
        
        set.add(nums[i]);
        buildSubset(set, i + 1);
        set.remove(set.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        buildSubset(set, i + 1);
    }
}
