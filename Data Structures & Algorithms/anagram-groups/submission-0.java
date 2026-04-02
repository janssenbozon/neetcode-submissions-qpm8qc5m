class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        for(String s : strs) {
            int[] freq = new int[26];
            for(char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            if(result.containsKey(key)) {
                result.get(key).add(s);
            } else {
                result.put(key, new ArrayList<>(Arrays.asList(s)));
            }
        }

        return new ArrayList<>(result.values());
    }
}
