class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // HashMap of current set
        // HashMap of s1
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        HashMap<Character, Integer> current = new HashMap<Character, Integer>();

        for(Character c : s1.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        // left pointer
        // right pointer
        int l = 0;
        // loop through, if current letter is in s1, add and start left pointer there
        // keep growing right pointer until perfect match
        // if no perfect match, then set left == right and start the process over
        while (l < s2.length()) {
            int r = l;
            while(r < s2.length() && target.containsKey(s2.charAt(r)) && target.get(s2.charAt(r)) > current.getOrDefault(s2.charAt(r), 0)) {
                current.put(s2.charAt(r), current.getOrDefault(s2.charAt(r), 0) + 1);
                r++;
                if(target.equals(current)) {
                    return true;
                }
            }
            
            l++;
            current.clear();
        }

        return false;
        
    }
}
