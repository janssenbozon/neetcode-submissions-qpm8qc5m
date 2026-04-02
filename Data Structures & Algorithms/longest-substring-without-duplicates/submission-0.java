class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> cur = new HashSet<Character>();

        if(s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        int i = 0;
        int j = 1;
        int max = 0;

        cur.add(s.charAt(i));

        while(j < s.length()) {

            if(cur.contains(s.charAt(j)) && i < j) {
                cur.remove(s.charAt(i));
                i++;
            } else {
                cur.add(s.charAt(j));
                j++;
            }
            max = Math.max(max, cur.size());
        }

        return max;
    }
}
