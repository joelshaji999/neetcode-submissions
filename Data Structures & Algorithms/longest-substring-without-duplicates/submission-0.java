class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> hs = new HashSet<>();
        int l = 0;
        int result = 0;

        for(int r = 0; r < s.length(); r++) {
            while(hs.contains(s.charAt(r))) {
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
